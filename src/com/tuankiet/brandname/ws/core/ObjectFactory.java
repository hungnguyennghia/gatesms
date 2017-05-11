
package com.tuankiet.brandname.ws.core;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.tuankiet.brandname.ws.core package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SendFlashDeliveryTime_QNAME = new QName("http://core.ws.brandname.tuankiet.com", "deliveryTime");
    private final static QName _SendFlashSign_QNAME = new QName("http://core.ws.brandname.tuankiet.com", "sign");
    private final static QName _SendFlashPhone_QNAME = new QName("http://core.ws.brandname.tuankiet.com", "phone");
    private final static QName _SendFlashSms_QNAME = new QName("http://core.ws.brandname.tuankiet.com", "sms");
    private final static QName _SendFlashIpAddress_QNAME = new QName("http://core.ws.brandname.tuankiet.com", "ipAddress");
    private final static QName _SendFlashAccount_QNAME = new QName("http://core.ws.brandname.tuankiet.com", "account");
    private final static QName _SendFlashFrom_QNAME = new QName("http://core.ws.brandname.tuankiet.com", "from");
    private final static QName _SendFlashCode_QNAME = new QName("http://core.ws.brandname.tuankiet.com", "code");
    private final static QName _GetStatusPartnerResponseReturn_QNAME = new QName("http://core.ws.brandname.tuankiet.com", "return");
    private final static QName _SendSmsToListPhoneSender_QNAME = new QName("http://core.ws.brandname.tuankiet.com", "sender");
    private final static QName _SendSmsToListPhonePhones_QNAME = new QName("http://core.ws.brandname.tuankiet.com", "phones");
    private final static QName _GetStatusPartnerUsername_QNAME = new QName("http://core.ws.brandname.tuankiet.com", "username");
    private final static QName _GetStatusPartnerPartnerId_QNAME = new QName("http://core.ws.brandname.tuankiet.com", "partnerId");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.tuankiet.brandname.ws.core
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SendFlash }
     * 
     */
    public SendFlash createSendFlash() {
        return new SendFlash();
    }

    /**
     * Create an instance of {@link SendSmsWap }
     * 
     */
    public SendSmsWap createSendSmsWap() {
        return new SendSmsWap();
    }

    /**
     * Create an instance of {@link CreateSenderResponse }
     * 
     */
    public CreateSenderResponse createCreateSenderResponse() {
        return new CreateSenderResponse();
    }

    /**
     * Create an instance of {@link SendSmsResponse }
     * 
     */
    public SendSmsResponse createSendSmsResponse() {
        return new SendSmsResponse();
    }

    /**
     * Create an instance of {@link SendUniResponse }
     * 
     */
    public SendUniResponse createSendUniResponse() {
        return new SendUniResponse();
    }

    /**
     * Create an instance of {@link SendSmsReportResponse }
     * 
     */
    public SendSmsReportResponse createSendSmsReportResponse() {
        return new SendSmsReportResponse();
    }

    /**
     * Create an instance of {@link GetStatusPartnerResponse }
     * 
     */
    public GetStatusPartnerResponse createGetStatusPartnerResponse() {
        return new GetStatusPartnerResponse();
    }

    /**
     * Create an instance of {@link SendResponse }
     * 
     */
    public SendResponse createSendResponse() {
        return new SendResponse();
    }

    /**
     * Create an instance of {@link SendSmsFlashResponse }
     * 
     */
    public SendSmsFlashResponse createSendSmsFlashResponse() {
        return new SendSmsFlashResponse();
    }

    /**
     * Create an instance of {@link SendSmsToListPhone }
     * 
     */
    public SendSmsToListPhone createSendSmsToListPhone() {
        return new SendSmsToListPhone();
    }

    /**
     * Create an instance of {@link CreateSender }
     * 
     */
    public CreateSender createCreateSender() {
        return new CreateSender();
    }

    /**
     * Create an instance of {@link SendSmsToListPhoneResponse }
     * 
     */
    public SendSmsToListPhoneResponse createSendSmsToListPhoneResponse() {
        return new SendSmsToListPhoneResponse();
    }

    /**
     * Create an instance of {@link GetBalanceResponse }
     * 
     */
    public GetBalanceResponse createGetBalanceResponse() {
        return new GetBalanceResponse();
    }

    /**
     * Create an instance of {@link SendSmsFlash }
     * 
     */
    public SendSmsFlash createSendSmsFlash() {
        return new SendSmsFlash();
    }

    /**
     * Create an instance of {@link GetBalance }
     * 
     */
    public GetBalance createGetBalance() {
        return new GetBalance();
    }

    /**
     * Create an instance of {@link Send }
     * 
     */
    public Send createSend() {
        return new Send();
    }

    /**
     * Create an instance of {@link SendSmsWapResponse }
     * 
     */
    public SendSmsWapResponse createSendSmsWapResponse() {
        return new SendSmsWapResponse();
    }

    /**
     * Create an instance of {@link GetBrandNamesResponse }
     * 
     */
    public GetBrandNamesResponse createGetBrandNamesResponse() {
        return new GetBrandNamesResponse();
    }

    /**
     * Create an instance of {@link GetBrandNames }
     * 
     */
    public GetBrandNames createGetBrandNames() {
        return new GetBrandNames();
    }

    /**
     * Create an instance of {@link SendSms }
     * 
     */
    public SendSms createSendSms() {
        return new SendSms();
    }

    /**
     * Create an instance of {@link SendUni }
     * 
     */
    public SendUni createSendUni() {
        return new SendUni();
    }

    /**
     * Create an instance of {@link SendSmsReport }
     * 
     */
    public SendSmsReport createSendSmsReport() {
        return new SendSmsReport();
    }

    /**
     * Create an instance of {@link GetStatusPartner }
     * 
     */
    public GetStatusPartner createGetStatusPartner() {
        return new GetStatusPartner();
    }

    /**
     * Create an instance of {@link SendFlashResponse }
     * 
     */
    public SendFlashResponse createSendFlashResponse() {
        return new SendFlashResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.ws.brandname.tuankiet.com", name = "deliveryTime", scope = SendFlash.class)
    public JAXBElement<String> createSendFlashDeliveryTime(String value) {
        return new JAXBElement<String>(_SendFlashDeliveryTime_QNAME, String.class, SendFlash.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.ws.brandname.tuankiet.com", name = "sign", scope = SendFlash.class)
    public JAXBElement<String> createSendFlashSign(String value) {
        return new JAXBElement<String>(_SendFlashSign_QNAME, String.class, SendFlash.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.ws.brandname.tuankiet.com", name = "phone", scope = SendFlash.class)
    public JAXBElement<String> createSendFlashPhone(String value) {
        return new JAXBElement<String>(_SendFlashPhone_QNAME, String.class, SendFlash.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.ws.brandname.tuankiet.com", name = "sms", scope = SendFlash.class)
    public JAXBElement<String> createSendFlashSms(String value) {
        return new JAXBElement<String>(_SendFlashSms_QNAME, String.class, SendFlash.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.ws.brandname.tuankiet.com", name = "ipAddress", scope = SendFlash.class)
    public JAXBElement<String> createSendFlashIpAddress(String value) {
        return new JAXBElement<String>(_SendFlashIpAddress_QNAME, String.class, SendFlash.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.ws.brandname.tuankiet.com", name = "account", scope = SendFlash.class)
    public JAXBElement<String> createSendFlashAccount(String value) {
        return new JAXBElement<String>(_SendFlashAccount_QNAME, String.class, SendFlash.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.ws.brandname.tuankiet.com", name = "from", scope = SendFlash.class)
    public JAXBElement<String> createSendFlashFrom(String value) {
        return new JAXBElement<String>(_SendFlashFrom_QNAME, String.class, SendFlash.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.ws.brandname.tuankiet.com", name = "code", scope = SendFlash.class)
    public JAXBElement<String> createSendFlashCode(String value) {
        return new JAXBElement<String>(_SendFlashCode_QNAME, String.class, SendFlash.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.ws.brandname.tuankiet.com", name = "phone", scope = SendSmsWap.class)
    public JAXBElement<String> createSendSmsWapPhone(String value) {
        return new JAXBElement<String>(_SendFlashPhone_QNAME, String.class, SendSmsWap.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.ws.brandname.tuankiet.com", name = "sms", scope = SendSmsWap.class)
    public JAXBElement<String> createSendSmsWapSms(String value) {
        return new JAXBElement<String>(_SendFlashSms_QNAME, String.class, SendSmsWap.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.ws.brandname.tuankiet.com", name = "account", scope = SendSmsWap.class)
    public JAXBElement<String> createSendSmsWapAccount(String value) {
        return new JAXBElement<String>(_SendFlashAccount_QNAME, String.class, SendSmsWap.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.ws.brandname.tuankiet.com", name = "from", scope = SendSmsWap.class)
    public JAXBElement<String> createSendSmsWapFrom(String value) {
        return new JAXBElement<String>(_SendFlashFrom_QNAME, String.class, SendSmsWap.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.ws.brandname.tuankiet.com", name = "code", scope = SendSmsWap.class)
    public JAXBElement<String> createSendSmsWapCode(String value) {
        return new JAXBElement<String>(_SendFlashCode_QNAME, String.class, SendSmsWap.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.ws.brandname.tuankiet.com", name = "return", scope = GetStatusPartnerResponse.class)
    public JAXBElement<String> createGetStatusPartnerResponseReturn(String value) {
        return new JAXBElement<String>(_GetStatusPartnerResponseReturn_QNAME, String.class, GetStatusPartnerResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.ws.brandname.tuankiet.com", name = "sender", scope = SendSmsToListPhone.class)
    public JAXBElement<String> createSendSmsToListPhoneSender(String value) {
        return new JAXBElement<String>(_SendSmsToListPhoneSender_QNAME, String.class, SendSmsToListPhone.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.ws.brandname.tuankiet.com", name = "sms", scope = SendSmsToListPhone.class)
    public JAXBElement<String> createSendSmsToListPhoneSms(String value) {
        return new JAXBElement<String>(_SendFlashSms_QNAME, String.class, SendSmsToListPhone.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.ws.brandname.tuankiet.com", name = "phones", scope = SendSmsToListPhone.class)
    public JAXBElement<String> createSendSmsToListPhonePhones(String value) {
        return new JAXBElement<String>(_SendSmsToListPhonePhones_QNAME, String.class, SendSmsToListPhone.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.ws.brandname.tuankiet.com", name = "account", scope = SendSmsToListPhone.class)
    public JAXBElement<String> createSendSmsToListPhoneAccount(String value) {
        return new JAXBElement<String>(_SendFlashAccount_QNAME, String.class, SendSmsToListPhone.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.ws.brandname.tuankiet.com", name = "code", scope = SendSmsToListPhone.class)
    public JAXBElement<String> createSendSmsToListPhoneCode(String value) {
        return new JAXBElement<String>(_SendFlashCode_QNAME, String.class, SendSmsToListPhone.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.ws.brandname.tuankiet.com", name = "sender", scope = CreateSender.class)
    public JAXBElement<String> createCreateSenderSender(String value) {
        return new JAXBElement<String>(_SendSmsToListPhoneSender_QNAME, String.class, CreateSender.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.ws.brandname.tuankiet.com", name = "account", scope = CreateSender.class)
    public JAXBElement<String> createCreateSenderAccount(String value) {
        return new JAXBElement<String>(_SendFlashAccount_QNAME, String.class, CreateSender.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.ws.brandname.tuankiet.com", name = "code", scope = CreateSender.class)
    public JAXBElement<String> createCreateSenderCode(String value) {
        return new JAXBElement<String>(_SendFlashCode_QNAME, String.class, CreateSender.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.ws.brandname.tuankiet.com", name = "phone", scope = SendSmsFlash.class)
    public JAXBElement<String> createSendSmsFlashPhone(String value) {
        return new JAXBElement<String>(_SendFlashPhone_QNAME, String.class, SendSmsFlash.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.ws.brandname.tuankiet.com", name = "sms", scope = SendSmsFlash.class)
    public JAXBElement<String> createSendSmsFlashSms(String value) {
        return new JAXBElement<String>(_SendFlashSms_QNAME, String.class, SendSmsFlash.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.ws.brandname.tuankiet.com", name = "account", scope = SendSmsFlash.class)
    public JAXBElement<String> createSendSmsFlashAccount(String value) {
        return new JAXBElement<String>(_SendFlashAccount_QNAME, String.class, SendSmsFlash.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.ws.brandname.tuankiet.com", name = "from", scope = SendSmsFlash.class)
    public JAXBElement<String> createSendSmsFlashFrom(String value) {
        return new JAXBElement<String>(_SendFlashFrom_QNAME, String.class, SendSmsFlash.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.ws.brandname.tuankiet.com", name = "code", scope = SendSmsFlash.class)
    public JAXBElement<String> createSendSmsFlashCode(String value) {
        return new JAXBElement<String>(_SendFlashCode_QNAME, String.class, SendSmsFlash.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.ws.brandname.tuankiet.com", name = "account", scope = GetBalance.class)
    public JAXBElement<String> createGetBalanceAccount(String value) {
        return new JAXBElement<String>(_SendFlashAccount_QNAME, String.class, GetBalance.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.ws.brandname.tuankiet.com", name = "code", scope = GetBalance.class)
    public JAXBElement<String> createGetBalanceCode(String value) {
        return new JAXBElement<String>(_SendFlashCode_QNAME, String.class, GetBalance.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.ws.brandname.tuankiet.com", name = "deliveryTime", scope = Send.class)
    public JAXBElement<String> createSendDeliveryTime(String value) {
        return new JAXBElement<String>(_SendFlashDeliveryTime_QNAME, String.class, Send.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.ws.brandname.tuankiet.com", name = "sign", scope = Send.class)
    public JAXBElement<String> createSendSign(String value) {
        return new JAXBElement<String>(_SendFlashSign_QNAME, String.class, Send.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.ws.brandname.tuankiet.com", name = "phone", scope = Send.class)
    public JAXBElement<String> createSendPhone(String value) {
        return new JAXBElement<String>(_SendFlashPhone_QNAME, String.class, Send.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.ws.brandname.tuankiet.com", name = "sms", scope = Send.class)
    public JAXBElement<String> createSendSms(String value) {
        return new JAXBElement<String>(_SendFlashSms_QNAME, String.class, Send.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.ws.brandname.tuankiet.com", name = "ipAddress", scope = Send.class)
    public JAXBElement<String> createSendIpAddress(String value) {
        return new JAXBElement<String>(_SendFlashIpAddress_QNAME, String.class, Send.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.ws.brandname.tuankiet.com", name = "account", scope = Send.class)
    public JAXBElement<String> createSendAccount(String value) {
        return new JAXBElement<String>(_SendFlashAccount_QNAME, String.class, Send.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.ws.brandname.tuankiet.com", name = "from", scope = Send.class)
    public JAXBElement<String> createSendFrom(String value) {
        return new JAXBElement<String>(_SendFlashFrom_QNAME, String.class, Send.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.ws.brandname.tuankiet.com", name = "code", scope = Send.class)
    public JAXBElement<String> createSendCode(String value) {
        return new JAXBElement<String>(_SendFlashCode_QNAME, String.class, Send.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.ws.brandname.tuankiet.com", name = "return", scope = GetBrandNamesResponse.class)
    public JAXBElement<String> createGetBrandNamesResponseReturn(String value) {
        return new JAXBElement<String>(_GetStatusPartnerResponseReturn_QNAME, String.class, GetBrandNamesResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.ws.brandname.tuankiet.com", name = "account", scope = GetBrandNames.class)
    public JAXBElement<String> createGetBrandNamesAccount(String value) {
        return new JAXBElement<String>(_SendFlashAccount_QNAME, String.class, GetBrandNames.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.ws.brandname.tuankiet.com", name = "code", scope = GetBrandNames.class)
    public JAXBElement<String> createGetBrandNamesCode(String value) {
        return new JAXBElement<String>(_SendFlashCode_QNAME, String.class, GetBrandNames.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.ws.brandname.tuankiet.com", name = "phone", scope = SendSms.class)
    public JAXBElement<String> createSendSmsPhone(String value) {
        return new JAXBElement<String>(_SendFlashPhone_QNAME, String.class, SendSms.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.ws.brandname.tuankiet.com", name = "sms", scope = SendSms.class)
    public JAXBElement<String> createSendSmsSms(String value) {
        return new JAXBElement<String>(_SendFlashSms_QNAME, String.class, SendSms.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.ws.brandname.tuankiet.com", name = "account", scope = SendSms.class)
    public JAXBElement<String> createSendSmsAccount(String value) {
        return new JAXBElement<String>(_SendFlashAccount_QNAME, String.class, SendSms.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.ws.brandname.tuankiet.com", name = "from", scope = SendSms.class)
    public JAXBElement<String> createSendSmsFrom(String value) {
        return new JAXBElement<String>(_SendFlashFrom_QNAME, String.class, SendSms.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.ws.brandname.tuankiet.com", name = "code", scope = SendSms.class)
    public JAXBElement<String> createSendSmsCode(String value) {
        return new JAXBElement<String>(_SendFlashCode_QNAME, String.class, SendSms.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.ws.brandname.tuankiet.com", name = "username", scope = GetStatusPartner.class)
    public JAXBElement<String> createGetStatusPartnerUsername(String value) {
        return new JAXBElement<String>(_GetStatusPartnerUsername_QNAME, String.class, GetStatusPartner.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.ws.brandname.tuankiet.com", name = "partnerId", scope = GetStatusPartner.class)
    public JAXBElement<String> createGetStatusPartnerPartnerId(String value) {
        return new JAXBElement<String>(_GetStatusPartnerPartnerId_QNAME, String.class, GetStatusPartner.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.ws.brandname.tuankiet.com", name = "code", scope = GetStatusPartner.class)
    public JAXBElement<String> createGetStatusPartnerCode(String value) {
        return new JAXBElement<String>(_SendFlashCode_QNAME, String.class, GetStatusPartner.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.ws.brandname.tuankiet.com", name = "phone", scope = SendSmsReport.class)
    public JAXBElement<String> createSendSmsReportPhone(String value) {
        return new JAXBElement<String>(_SendFlashPhone_QNAME, String.class, SendSmsReport.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.ws.brandname.tuankiet.com", name = "sms", scope = SendSmsReport.class)
    public JAXBElement<String> createSendSmsReportSms(String value) {
        return new JAXBElement<String>(_SendFlashSms_QNAME, String.class, SendSmsReport.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.ws.brandname.tuankiet.com", name = "partnerId", scope = SendSmsReport.class)
    public JAXBElement<String> createSendSmsReportPartnerId(String value) {
        return new JAXBElement<String>(_GetStatusPartnerPartnerId_QNAME, String.class, SendSmsReport.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.ws.brandname.tuankiet.com", name = "account", scope = SendSmsReport.class)
    public JAXBElement<String> createSendSmsReportAccount(String value) {
        return new JAXBElement<String>(_SendFlashAccount_QNAME, String.class, SendSmsReport.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.ws.brandname.tuankiet.com", name = "from", scope = SendSmsReport.class)
    public JAXBElement<String> createSendSmsReportFrom(String value) {
        return new JAXBElement<String>(_SendFlashFrom_QNAME, String.class, SendSmsReport.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.ws.brandname.tuankiet.com", name = "code", scope = SendSmsReport.class)
    public JAXBElement<String> createSendSmsReportCode(String value) {
        return new JAXBElement<String>(_SendFlashCode_QNAME, String.class, SendSmsReport.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.ws.brandname.tuankiet.com", name = "phone", scope = SendUni.class)
    public JAXBElement<String> createSendUniPhone(String value) {
        return new JAXBElement<String>(_SendFlashPhone_QNAME, String.class, SendUni.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.ws.brandname.tuankiet.com", name = "sms", scope = SendUni.class)
    public JAXBElement<String> createSendUniSms(String value) {
        return new JAXBElement<String>(_SendFlashSms_QNAME, String.class, SendUni.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.ws.brandname.tuankiet.com", name = "account", scope = SendUni.class)
    public JAXBElement<String> createSendUniAccount(String value) {
        return new JAXBElement<String>(_SendFlashAccount_QNAME, String.class, SendUni.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.ws.brandname.tuankiet.com", name = "from", scope = SendUni.class)
    public JAXBElement<String> createSendUniFrom(String value) {
        return new JAXBElement<String>(_SendFlashFrom_QNAME, String.class, SendUni.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.ws.brandname.tuankiet.com", name = "code", scope = SendUni.class)
    public JAXBElement<String> createSendUniCode(String value) {
        return new JAXBElement<String>(_SendFlashCode_QNAME, String.class, SendUni.class, value);
    }

}
