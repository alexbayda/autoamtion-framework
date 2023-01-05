package ca.canadiantire.core.allure;

import io.qameta.allure.attachment.DefaultAttachmentProcessor;
import io.qameta.allure.attachment.FreemarkerAttachmentRenderer;
import io.qameta.allure.attachment.http.HttpRequestAttachment;
import io.qameta.allure.attachment.http.HttpResponseAttachment;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.filter.FilterContext;
import io.restassured.internal.NameAndValue;
import io.restassured.internal.support.Prettifier;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static io.qameta.allure.attachment.http.HttpRequestAttachment.Builder.create;

public class AllureRestAssuredFilter extends AllureRestAssured {
    public static final String SUBSCRIPTION_KEY_HEADER = "Ocp-Apim-Subscription-Key";
    public static final String AUTHORIZATION_HEADER = "Authorization";
    public static final String SUBSCRIPTION_KEY_PLACEHOLDER = "{{Ocp-Apim-Subscription-Key}}";
    public static final String AUTHORIZATION_PLACEHOLDER = "{{Authorization}}";
    private String requestTemplatePath = "http-request.ftl";
    private String responseTemplatePath = "http-response.ftl";
    private String requestAttachmentName = "Request";
    private String responseAttachmentName;

    @Override
    public Response filter(final FilterableRequestSpecification requestSpec,
                           final FilterableResponseSpecification responseSpec,
                           final FilterContext filterContext) {
        final Prettifier prettifier = new Prettifier();
        final String url = requestSpec.getURI();
        final HttpRequestAttachment.Builder requestAttachmentBuilder = create(requestAttachmentName, url)
                .setMethod(requestSpec.getMethod())
                .setHeaders(filterHeaders(toMapConverter(requestSpec.getHeaders())))
                .setCookies(toMapConverter(requestSpec.getCookies()));

        if (Objects.nonNull(requestSpec.getBody())) {
            requestAttachmentBuilder.setBody(prettifier.getPrettifiedBodyIfPossible(requestSpec));
        }

        final HttpRequestAttachment requestAttachment = requestAttachmentBuilder.build();

        new DefaultAttachmentProcessor().addAttachment(
                requestAttachment,
                new FreemarkerAttachmentRenderer(requestTemplatePath)
        );

        final Response response = filterContext.next(requestSpec, responseSpec);
        if (Objects.isNull(responseAttachmentName)) {
            responseAttachmentName = response.getStatusLine();
        }
        final HttpResponseAttachment responseAttachment = HttpResponseAttachment.Builder.create(responseAttachmentName)
                .setResponseCode(response.getStatusCode())
                .setHeaders(toMapConverter(response.getHeaders()))
                .setBody(prettifier.getPrettifiedBodyIfPossible(response, response.getBody()))
                .build();

        new DefaultAttachmentProcessor().addAttachment(
                responseAttachment,
                new FreemarkerAttachmentRenderer(responseTemplatePath)
        );

        return response;
    }

    private Map<String, String> filterHeaders(Map<String, String> map) {
        for (Map.Entry<String, String> stringStringEntry : map.entrySet()) {
            if (stringStringEntry.getKey().equals(SUBSCRIPTION_KEY_HEADER)){
                map.put(stringStringEntry.getKey(), SUBSCRIPTION_KEY_PLACEHOLDER);
            }
            if (stringStringEntry.getKey().equals(AUTHORIZATION_HEADER)){
                map.put(stringStringEntry.getKey(), AUTHORIZATION_PLACEHOLDER);
            }
        }
        return map;
    }

    private static Map<String, String> toMapConverter(final Iterable<? extends NameAndValue> items) {
        final Map<String, String> result = new HashMap<>();
        items.forEach(h -> result.put(h.getName(), h.getValue()));
        return result;
    }
}
