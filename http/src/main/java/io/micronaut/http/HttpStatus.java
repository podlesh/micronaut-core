/*
 * Copyright 2017-2019 original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.micronaut.http;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Represents HTTP status codes. See https://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html.
 *
 * @author Graeme Rocher
 * @since 1.0
 */
public enum HttpStatus implements CharSequence {
    CONTINUE(100, "Continue"),
    SWITCHING_PROTOCOLS(101, "Switching Protocols"),
    PROCESSING(102, "Processing"),
    OK(200, "Ok"),
    CREATED(201, "Created"),
    ACCEPTED(202, "Accepted"),
    NON_AUTHORITATIVE_INFORMATION(203, "Non-Authoritative Information"),
    NO_CONTENT(204, "No Content"),
    RESET_CONTENT(205, "Reset Content"),
    PARTIAL_CONTENT(206, "Partial Content"),
    MULTI_STATUS(207, "Multi Status"),
    ALREADY_IMPORTED(208, "Already imported"),
    IM_USED(226, "IM Used"),
    MULTIPLE_CHOICES(300, "Multiple Choices"),
    MOVED_PERMANENTLY(301, "Moved Permanently"),
    FOUND(302, "Found"),
    SEE_OTHER(303, "See Other"),
    NOT_MODIFIED(304, "Not Modified"),
    USE_PROXY(305, "Use Proxy"),
    SWITCH_PROXY(306, "Switch Proxy"),
    TEMPORARY_REDIRECT(307, "Temporary Redirect"),
    PERMANENT_REDIRECT(308, "Permanent Redirect"),
    BAD_REQUEST(400, "Bad Request"),
    UNAUTHORIZED(401, "Unauthorized"),
    PAYMENT_REQUIRED(402, "Payment Required"),
    FORBIDDEN(403, "Forbidden"),
    NOT_FOUND(404, "Not Found"),
    METHOD_NOT_ALLOWED(405, "Method Not Allowed"),
    NOT_ACCEPTABLE(406, "Not Acceptable"),
    PROXY_AUTHENTICATION_REQUIRED(407, "Proxy Authentication Required"),
    REQUEST_TIMEOUT(408, "Request Timeout"),
    CONFLICT(409, "Conflict"),
    GONE(410, "Gone"),
    LENGTH_REQUIRED(411, "Length Required"),
    PRECONDITION_FAILED(412, "Precondition Failed"),
    REQUEST_ENTITY_TOO_LARGE(413, "Request Entity Too Large"),
    REQUEST_URI_TOO_LONG(414, "Request-URI Too Long"),
    UNSUPPORTED_MEDIA_TYPE(415, "Unsupported Media Type"),
    REQUESTED_RANGE_NOT_SATISFIABLE(416, "Requested Range Not Satisfiable"),
    EXPECTATION_FAILED(417, "Expectation Failed"),
    I_AM_A_TEAPOT(418, "I am a teapot"),
    ENHANCE_YOUR_CALM(420, "Enhance your calm"),
    UNPROCESSABLE_ENTITY(422, "Unprocessable Entity"),
    LOCKED(423, "Locked"),
    FAILED_DEPENDENCY(424, "Failed Dependency"),
    UNORDERED_COLLECTION(425, "Unordered Collection"),
    UPGRADE_REQUIRED(426, "Upgrade Required"),
    PRECONDITION_REQUIRED(428, "Precondition Required"),
    TOO_MANY_REQUESTS(429, "Too Many Requests"),
    REQUEST_HEADER_FIELDS_TOO_LARGE(431, "Request Header Fields Too Large"),
    NO_RESPONSE(444, "No Response"),
    BLOCKED_BY_WINDOWS_PARENTAL_CONTROLS(450, "Blocked by Windows Parental Controls"),
    UNAVAILABLE_FOR_LEGAL_REASONS(451, "Unavailable For Legal Reasons"),
    REQUEST_HEADER_TOO_LARGE(494, "Request Header Too Large"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
    NOT_IMPLEMENTED(501, "Not Implemented"),
    BAD_GATEWAY(502, "Bad Gateway"),
    SERVICE_UNAVAILABLE(503, "Service Unavailable"),
    GATEWAY_TIMEOUT(504, "Gateway Timeout"),
    HTTP_VERSION_NOT_SUPPORTED(505, "HTTP Version Not Supported"),
    VARIANT_ALSO_NEGOTIATES(506, "Variant Also Negotiates"),
    INSUFFICIENT_STORAGE(507, "Insufficient Storage"),
    LOOP_DETECTED(508, "Loop Detected"),
    BANDWIDTH_LIMIT_EXCEEDED(509, "Bandwidth Limit Exceeded"),
    NOT_EXTENDED(510, "Not Extended"),
    NETWORK_AUTHENTICATION_REQUIRED(511, "Network Authentication Required"),
    CONNECTION_TIMED_OUT(522, "Connection Timed Out"),

    //non-standard codes are quite often used by various REST APIs
    //  and in current state, http client just completely fails and does not allow any mechanism to handle such errors
    ERROR_419(419, "Non-standard error code 419"),
    ERROR_421(421, "Non-standard error code 421"),
    ERROR_427(427, "Non-standard error code 427"),
    ERROR_430(430, "Non-standard error code 430"),
    ERROR_432(432, "Non-standard error code 432"),
    ERROR_433(433, "Non-standard error code 433"),
    ERROR_434(434, "Non-standard error code 434"),
    ERROR_435(435, "Non-standard error code 435"),
    ERROR_436(436, "Non-standard error code 436"),
    ERROR_437(437, "Non-standard error code 437"),
    ERROR_438(438, "Non-standard error code 438"),
    ERROR_439(439, "Non-standard error code 439"),
    ERROR_440(440, "Non-standard error code 440"),
    ERROR_441(441, "Non-standard error code 441"),
    ERROR_442(442, "Non-standard error code 442"),
    ERROR_443(443, "Non-standard error code 443"),
    ERROR_445(445, "Non-standard error code 445"),
    ERROR_446(446, "Non-standard error code 446"),
    ERROR_447(447, "Non-standard error code 447"),
    ERROR_448(448, "Non-standard error code 448"),
    ERROR_449(449, "Non-standard error code 449"),
    ERROR_452(452, "Non-standard error code 452"),
    ERROR_453(453, "Non-standard error code 453"),
    ERROR_454(454, "Non-standard error code 454"),
    ERROR_455(455, "Non-standard error code 455"),
    ERROR_456(456, "Non-standard error code 456"),
    ERROR_457(457, "Non-standard error code 457"),
    ERROR_458(458, "Non-standard error code 458"),
    ERROR_459(459, "Non-standard error code 459"),
    ERROR_460(460, "Non-standard error code 460"),
    ERROR_461(461, "Non-standard error code 461"),
    ERROR_462(462, "Non-standard error code 462"),
    ERROR_463(463, "Non-standard error code 463"),
    ERROR_464(464, "Non-standard error code 464"),
    ERROR_465(465, "Non-standard error code 465"),
    ERROR_466(466, "Non-standard error code 466"),
    ERROR_467(467, "Non-standard error code 467"),
    ERROR_468(468, "Non-standard error code 468"),
    ERROR_469(469, "Non-standard error code 469"),
    ERROR_470(470, "Non-standard error code 470"),
    ERROR_471(471, "Non-standard error code 471"),
    ERROR_472(472, "Non-standard error code 472"),
    ERROR_473(473, "Non-standard error code 473"),
    ERROR_474(474, "Non-standard error code 474"),
    ERROR_475(475, "Non-standard error code 475"),
    ERROR_476(476, "Non-standard error code 476"),
    ERROR_477(477, "Non-standard error code 477"),
    ERROR_478(478, "Non-standard error code 478"),
    ERROR_479(479, "Non-standard error code 479"),
    ERROR_480(480, "Non-standard error code 480"),
    ERROR_481(481, "Non-standard error code 481"),
    ERROR_482(482, "Non-standard error code 482"),
    ERROR_483(483, "Non-standard error code 483"),
    ERROR_484(484, "Non-standard error code 484"),
    ERROR_485(485, "Non-standard error code 485"),
    ERROR_486(486, "Non-standard error code 486"),
    ERROR_487(487, "Non-standard error code 487"),
    ERROR_488(488, "Non-standard error code 488"),
    ERROR_489(489, "Non-standard error code 489"),
    ERROR_490(490, "Non-standard error code 490"),
    ERROR_491(491, "Non-standard error code 491"),
    ERROR_492(492, "Non-standard error code 492"),
    ERROR_493(493, "Non-standard error code 493"),
    ERROR_495(495, "Non-standard error code 495"),
    ERROR_496(496, "Non-standard error code 496"),
    ERROR_497(497, "Non-standard error code 497"),
    ERROR_498(498, "Non-standard error code 498"),
    ERROR_499(499, "Non-standard error code 499"),
    ERROR_512(512, "Non-standard error code 512"),
    ERROR_513(513, "Non-standard error code 513"),
    ERROR_514(514, "Non-standard error code 514"),
    ERROR_515(515, "Non-standard error code 515"),
    ERROR_516(516, "Non-standard error code 516"),
    ERROR_517(517, "Non-standard error code 517"),
    ERROR_518(518, "Non-standard error code 518"),
    ERROR_519(519, "Non-standard error code 519"),
    ERROR_520(520, "Non-standard error code 520"),
    ERROR_521(521, "Non-standard error code 521"),
    ERROR_523(523, "Non-standard error code 523"),
    ERROR_524(524, "Non-standard error code 524"),
    ERROR_525(525, "Non-standard error code 525"),
    ERROR_526(526, "Non-standard error code 526"),
    ERROR_527(527, "Non-standard error code 527"),
    ERROR_528(528, "Non-standard error code 528"),
    ERROR_529(529, "Non-standard error code 529"),
    ERROR_530(530, "Non-standard error code 530"),
    ERROR_531(531, "Non-standard error code 531"),
    ERROR_532(532, "Non-standard error code 532"),
    ERROR_533(533, "Non-standard error code 533"),
    ERROR_534(534, "Non-standard error code 534"),
    ERROR_535(535, "Non-standard error code 535"),
    ERROR_536(536, "Non-standard error code 536"),
    ERROR_537(537, "Non-standard error code 537"),
    ERROR_538(538, "Non-standard error code 538"),
    ERROR_539(539, "Non-standard error code 539"),
    ERROR_540(540, "Non-standard error code 540"),
    ERROR_541(541, "Non-standard error code 541"),
    ERROR_542(542, "Non-standard error code 542"),
    ERROR_543(543, "Non-standard error code 543"),
    ERROR_544(544, "Non-standard error code 544"),
    ERROR_545(545, "Non-standard error code 545"),
    ERROR_546(546, "Non-standard error code 546"),
    ERROR_547(547, "Non-standard error code 547"),
    ERROR_548(548, "Non-standard error code 548"),
    ERROR_549(549, "Non-standard error code 549"),
    ERROR_550(550, "Non-standard error code 550"),
    ERROR_551(551, "Non-standard error code 551"),
    ERROR_552(552, "Non-standard error code 552"),
    ERROR_553(553, "Non-standard error code 553"),
    ERROR_554(554, "Non-standard error code 554"),
    ERROR_555(555, "Non-standard error code 555"),
    ERROR_556(556, "Non-standard error code 556"),
    ERROR_557(557, "Non-standard error code 557"),
    ERROR_558(558, "Non-standard error code 558"),
    ERROR_559(559, "Non-standard error code 559"),
    ERROR_560(560, "Non-standard error code 560"),
    ERROR_561(561, "Non-standard error code 561"),
    ERROR_562(562, "Non-standard error code 562"),
    ERROR_563(563, "Non-standard error code 563"),
    ERROR_564(564, "Non-standard error code 564"),
    ERROR_565(565, "Non-standard error code 565"),
    ERROR_566(566, "Non-standard error code 566"),
    ERROR_567(567, "Non-standard error code 567"),
    ERROR_568(568, "Non-standard error code 568"),
    ERROR_569(569, "Non-standard error code 569"),
    ERROR_570(570, "Non-standard error code 570"),
    ERROR_571(571, "Non-standard error code 571"),
    ERROR_572(572, "Non-standard error code 572"),
    ERROR_573(573, "Non-standard error code 573"),
    ERROR_574(574, "Non-standard error code 574"),
    ERROR_575(575, "Non-standard error code 575"),
    ERROR_576(576, "Non-standard error code 576"),
    ERROR_577(577, "Non-standard error code 577"),
    ERROR_578(578, "Non-standard error code 578"),
    ERROR_579(579, "Non-standard error code 579"),
    ERROR_580(580, "Non-standard error code 580"),
    ERROR_581(581, "Non-standard error code 581"),
    ERROR_582(582, "Non-standard error code 582"),
    ERROR_583(583, "Non-standard error code 583"),
    ERROR_584(584, "Non-standard error code 584"),
    ERROR_585(585, "Non-standard error code 585"),
    ERROR_586(586, "Non-standard error code 586"),
    ERROR_587(587, "Non-standard error code 587"),
    ERROR_588(588, "Non-standard error code 588"),
    ERROR_589(589, "Non-standard error code 589"),
    ERROR_590(590, "Non-standard error code 590"),
    ERROR_591(591, "Non-standard error code 591"),
    ERROR_592(592, "Non-standard error code 592"),
    ERROR_593(593, "Non-standard error code 593"),
    ERROR_594(594, "Non-standard error code 594"),
    ERROR_595(595, "Non-standard error code 595"),
    ERROR_596(596, "Non-standard error code 596"),
    ERROR_597(597, "Non-standard error code 597"),
    ERROR_598(598, "Non-standard error code 598"),
    ERROR_599(599, "Non-standard error code 599"),
    //end if non-standard error codes
    ;

    private static final Map<Integer, HttpStatus> BY_CODE;

    static {
        HttpStatus[] statuses = values();
        Map<Integer, HttpStatus> byCode = new LinkedHashMap<>();
        for (HttpStatus status : statuses) {
            //note: in case of duplicity, first instance has always precedence
            byCode.putIfAbsent(status.code, status);
        }

        BY_CODE = Collections.unmodifiableMap(byCode);
    }

    private final int code;
    private final String reason;

    /**
     * @param code   The code
     * @param reason The reason
     */
    HttpStatus(int code, String reason) {
        Objects.requireNonNull(reason, "Argument 'reason' cannot be null");
        this.code = code;
        this.reason = reason;
    }

    /**
     * @return The reason text
     */
    public String getReason() {
        return reason;
    }

    /**
     * @return The code
     */
    public int getCode() {
        return code;
    }

    /**
     * The status for the given code.
     *
     * @param code The code
     * @return The value
     */
    public static HttpStatus valueOf(int code) {
        HttpStatus status = BY_CODE.get(code);
        if (status == null) {
            throw new IllegalArgumentException("Invalid HTTP status code: " + code);
        }
        return status;
    }

    @Override
    public int length() {
        return name().length();
    }

    @Override
    public char charAt(int index) {
        return name().charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return name().subSequence(start, end);
    }
}
