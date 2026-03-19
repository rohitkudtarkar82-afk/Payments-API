package Payments.Group.Payments.ServiceImpl;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.Channel;
import java.util.List;
import java.util.prefs.BackingStoreException;
import java.util.prefs.NodeChangeListener;
import java.util.prefs.PreferenceChangeListener;
import java.util.prefs.Preferences;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Service;

import Payments.Group.Payments.DTO.AmountRequestDTO;
import Payments.Group.Payments.DTO.AmountResponseDTO;
import Payments.Group.Payments.DTO.Authorized_PaymentRequestDTO;
import Payments.Group.Payments.DTO.Authorized_PaymentResponseDTO;
import Payments.Group.Payments.DTO.BreakdownRequestDTO;
import Payments.Group.Payments.DTO.BreakdownResponseDTO;
import Payments.Group.Payments.DTO.Capture_PaymentRequestDTO;
import Payments.Group.Payments.DTO.Capture_PaymentResponseDTO;
import Payments.Group.Payments.DTO.ChannelRequestDTO;
import Payments.Group.Payments.DTO.CustomerRequestDTO;
import Payments.Group.Payments.DTO.DiscountRequestDTO;
import Payments.Group.Payments.DTO.DiscountResponseDTO;
import Payments.Group.Payments.DTO.Eligible_MethodsResponseDTO;
import Payments.Group.Payments.DTO.Exchange_RateResponseDTO;
import Payments.Group.Payments.DTO.Gross_AmountResponseDTO;
import Payments.Group.Payments.DTO.HandlingRequestDTO;
import Payments.Group.Payments.DTO.HandlingResponseDTO;
import Payments.Group.Payments.DTO.InsuranceRequestDTO;
import Payments.Group.Payments.DTO.InsuranceResponseDTO;
import Payments.Group.Payments.DTO.Item_TotalRequestDTO;
import Payments.Group.Payments.DTO.Item_TotalResponseDTO;
import Payments.Group.Payments.DTO.LinksResponseDTO;
import Payments.Group.Payments.DTO.List_Eligible_PaymentRequestDTO;
import Payments.Group.Payments.DTO.List_Eligible_PaymentResponseDTO;
import Payments.Group.Payments.DTO.MediaResponseDTO;
import Payments.Group.Payments.DTO.Net_AmountResponseDTO;
import Payments.Group.Payments.DTO.Network_Transaction_ReferenceResponseDTO;
import Payments.Group.Payments.DTO.PayeeRequestDTO;
import Payments.Group.Payments.DTO.PayeeResponseDTO;
import Payments.Group.Payments.DTO.PayerResponseDTO;
import Payments.Group.Payments.DTO.Payment_InstructionRequestDTO;
import Payments.Group.Payments.DTO.Payment_SourceResponseDTO;
import Payments.Group.Payments.DTO.Payment_Source_ConstraintRequestDTO;
import Payments.Group.Payments.DTO.Payment_Source_PaypalResponseDTO;
import Payments.Group.Payments.DTO.Payment_Source_VenmoResponseDTO;
import Payments.Group.Payments.DTO.Payment_TokensResponseDTO;
import Payments.Group.Payments.DTO.PaypalResponseDTO;
import Payments.Group.Payments.DTO.Paypal_CreditResponseDTO;
import Payments.Group.Payments.DTO.Paypal_FeeResponseDTO;
import Payments.Group.Payments.DTO.Paypal_Fee_Receivable_CurrencyResponseDTO;
import Payments.Group.Payments.DTO.Paypal_Pay_LaterResponseDTO;
import Payments.Group.Payments.DTO.PhoneRequestDTO;
import Payments.Group.Payments.DTO.Platform_FeesRequestDTO;
import Payments.Group.Payments.DTO.Platform_FeesResponseDTO;
import Payments.Group.Payments.DTO.PreferencesRequestDTO;
import Payments.Group.Payments.DTO.Processor_ResponseResponseDTO;
import Payments.Group.Payments.DTO.Purchase_UnitsRequestDTO;
import Payments.Group.Payments.DTO.Reauthorize_PaymentRequestDTO;
import Payments.Group.Payments.DTO.Reauthorize_PaymentResponseDTO;
import Payments.Group.Payments.DTO.Receivable_AmountResponseDTO;
import Payments.Group.Payments.DTO.Refund_Captured_PaymentRequestDTO;
import Payments.Group.Payments.DTO.Refund_Captured_PaymentResponseDTO;
import Payments.Group.Payments.DTO.Related_IdsResponseDTO;
import Payments.Group.Payments.DTO.SchemaResponseDTO;
import Payments.Group.Payments.DTO.Seller_Payable_BreakdownResponseDTO;
import Payments.Group.Payments.DTO.Seller_ProtectionResponseDTO;
import Payments.Group.Payments.DTO.Seller_Receivable_BreakdownResponseDTO;
import Payments.Group.Payments.DTO.ShippingRequestDTO;
import Payments.Group.Payments.DTO.ShippingResponseDTO;
import Payments.Group.Payments.DTO.Shipping_DiscountRequestDTO;
import Payments.Group.Payments.DTO.Shipping_DiscountResponseDTO;
import Payments.Group.Payments.DTO.Show_Captured_PaymentResponseDTO;
import Payments.Group.Payments.DTO.Show_Details_PaymentResponseDTO;
import Payments.Group.Payments.DTO.Show_Refund_DetailsResponseDTO;
import Payments.Group.Payments.DTO.Status_DetailsResponseDTO;
import Payments.Group.Payments.DTO.Supplementary_DataResponseDTO;
import Payments.Group.Payments.DTO.Target_SchemaResponseDTO;
import Payments.Group.Payments.DTO.Tax_TotalRequestDTO;
import Payments.Group.Payments.DTO.Tax_TotalResponseDTO;
import Payments.Group.Payments.DTO.VenmoResponseDTO;
import Payments.Group.Payments.Entity.Amount;
import Payments.Group.Payments.Entity.Customer;
import Payments.Group.Payments.Entity.Discount;
import Payments.Group.Payments.Entity.Exchange_Rate;
import Payments.Group.Payments.Entity.Gross_Amount;
import Payments.Group.Payments.Entity.Handling;
import Payments.Group.Payments.Entity.Insurance;
import Payments.Group.Payments.Entity.Item_Total;
import Payments.Group.Payments.Entity.Links;
import Payments.Group.Payments.Entity.Media;
import Payments.Group.Payments.Entity.Net_Amount;
import Payments.Group.Payments.Entity.Network_Transaction_Reference;
import Payments.Group.Payments.Entity.Payee;
import Payments.Group.Payments.Entity.Payment_Instruction;
import Payments.Group.Payments.Entity.Payment_Source_Constraint;
import Payments.Group.Payments.Entity.Payment_Source_Paypal;
import Payments.Group.Payments.Entity.Payment_Source_Venmo;
import Payments.Group.Payments.Entity.Payment_Tokens;
import Payments.Group.Payments.Entity.Paypal;
import Payments.Group.Payments.Entity.Paypal_Credit;
import Payments.Group.Payments.Entity.Paypal_Fee;
import Payments.Group.Payments.Entity.Paypal_Fee_Receivable_Currency;
import Payments.Group.Payments.Entity.Paypal_Pay_Later;
import Payments.Group.Payments.Entity.Phone;
import Payments.Group.Payments.Entity.Processor_Response;
import Payments.Group.Payments.Entity.Receivable_Amount;
import Payments.Group.Payments.Entity.Related_Ids;
import Payments.Group.Payments.Entity.Schema;
import Payments.Group.Payments.Entity.Seller_Protection;
import Payments.Group.Payments.Entity.Shipping;
import Payments.Group.Payments.Entity.Shipping_Discount;
import Payments.Group.Payments.Entity.Status_Details;
import Payments.Group.Payments.Entity.Target_Schema;
import Payments.Group.Payments.Entity.Tax_Total;
import Payments.Group.Payments.Entity.Venmo;
import Payments.Group.Payments.Repository.AmountRepository;
import Payments.Group.Payments.Repository.ChannelRepository;
import Payments.Group.Payments.Repository.CustomerRepository;
import Payments.Group.Payments.Repository.DiscountRepository;
import Payments.Group.Payments.Repository.Exchange_RateRepository;
import Payments.Group.Payments.Repository.Gross_AmountRepository;
import Payments.Group.Payments.Repository.HandlingRepository;
import Payments.Group.Payments.Repository.InsuranceRepository;
import Payments.Group.Payments.Repository.Item_TotalRepository;
import Payments.Group.Payments.Repository.LinksRepository;
import Payments.Group.Payments.Repository.MediaRepository;
import Payments.Group.Payments.Repository.Net_AmountRepository;
import Payments.Group.Payments.Repository.Network_Transaction_ReferenceRepository;
import Payments.Group.Payments.Repository.PayeeRepository;
import Payments.Group.Payments.Repository.Payment_InstructionRepository;
import Payments.Group.Payments.Repository.Payment_Source_ConstraintRepository;
import Payments.Group.Payments.Repository.Payment_Source_PaypalRepository;
import Payments.Group.Payments.Repository.Payment_Source_VenmoRepository;
import Payments.Group.Payments.Repository.Payment_TokensRepository;
import Payments.Group.Payments.Repository.PaypalRepository;
import Payments.Group.Payments.Repository.Paypal_CreditRepository;
import Payments.Group.Payments.Repository.Paypal_FeeRepository;
import Payments.Group.Payments.Repository.Paypal_Pay_LaterRepository;
import Payments.Group.Payments.Repository.PhoneRepository;
import Payments.Group.Payments.Repository.PreferencesRepository;
import Payments.Group.Payments.Repository.Processor_ResponseRepository;
import Payments.Group.Payments.Repository.Receivable_AmountRepository;
import Payments.Group.Payments.Repository.Related_IdsRepository;
import Payments.Group.Payments.Repository.SchemaRepository;
import Payments.Group.Payments.Repository.Seller_ProtectionRepository;
import Payments.Group.Payments.Repository.ShippingRepository;
import Payments.Group.Payments.Repository.Shipping_DiscountRepository;
import Payments.Group.Payments.Repository.Status_DetailsRepository;
import Payments.Group.Payments.Repository.Target_SchemaRepository;
import Payments.Group.Payments.Repository.Tax_TotalRepository;
import Payments.Group.Payments.Repository.VenmoRepository;
import Payments.Group.Payments.Service.PaymentsService;

@Service
public class PaymentsServiceImpl implements PaymentsService {
        
    // Initialize Repository
    private AmountRepository amountRepository;
    private Payment_InstructionRepository payment_InstructionRepository;
    private PayeeRepository payeeRepository;
    private Status_DetailsRepository status_DetailsRepository;
    private Network_Transaction_ReferenceRepository network_Transaction_ReferenceRepository;
    private Seller_ProtectionRepository seller_ProtectionRepository;
    private LinksRepository linksRepository;
    private Processor_ResponseRepository processor_ResponseRepository;
    private Item_TotalRepository item_TotalRepository;
    private ShippingRepository shippingRepository;
    private HandlingRepository handlingRepository;
    private Tax_TotalRepository tax_TotalRepository;
    private InsuranceRepository insuranceRepository;
    private Shipping_DiscountRepository shipping_DiscountRepository;
    private DiscountRepository discountRepository;
    private Gross_AmountRepository gross_AmountRepository;
    private Paypal_FeeRepository paypal_FeeRepository;
    private Net_AmountRepository net_AmountRepository;
    private Receivable_AmountRepository receivable_AmountRepository;
    private Exchange_RateRepository exchange_RateRepository;
    private Related_IdsRepository related_IdsRepository;
    private SchemaRepository schemaRepository;
    private Target_SchemaRepository target_SchemaRepository;
    private MediaRepository mediaRepository;
    private CustomerRepository customerRepository;
    private ChannelRepository channelRepository;
    private PhoneRepository phoneRepository;
    private PreferencesRepository preferencesRepository;
    private Payment_Source_ConstraintRepository payment_Source_ConstraintRepository;
    private PaypalRepository paypalRepository;
    private VenmoRepository venmoRepository;
    private Paypal_CreditRepository paypal_CreditRepository;
    private Paypal_Pay_LaterRepository paypal_Pay_LaterRepository;
    private Payment_TokensRepository payment_TokensRepository;
    private Payment_Source_PaypalRepository payment_Source_PaypalRepository;
    private Payment_Source_VenmoRepository payment_Source_VenmoRepository;

    


    
  
    
    
    


     /*  @Override
    public Show_Details_PaymentResponseDTO show_Details_Payment(String authorizationid, String Authorization,
            String PayPalAuthAssertion) {
        
                

                
        
    } */



    
    // Initialize Constructor
    @Autowired
       public PaymentsServiceImpl(AmountRepository amountRepository,
            Payment_InstructionRepository payment_InstructionRepository, PayeeRepository payeeRepository,
            Status_DetailsRepository status_DetailsRepository,
            Network_Transaction_ReferenceRepository network_Transaction_ReferenceRepository,
            Seller_ProtectionRepository seller_ProtectionRepository, LinksRepository linksRepository,
            Processor_ResponseRepository processor_ResponseRepository, Item_TotalRepository item_TotalRepository,
            ShippingRepository shippingRepository, HandlingRepository handlingRepository,
            Tax_TotalRepository tax_TotalRepository, InsuranceRepository insuranceRepository,
            Shipping_DiscountRepository shipping_DiscountRepository, DiscountRepository discountRepository,
            Gross_AmountRepository gross_AmountRepository, Paypal_FeeRepository paypal_FeeRepository,
            Net_AmountRepository net_AmountRepository, Receivable_AmountRepository receivable_AmountRepository,
            Exchange_RateRepository exchange_RateRepository, Related_IdsRepository related_IdsRepository,
            SchemaRepository schemaRepository, Target_SchemaRepository target_SchemaRepository,
            MediaRepository mediaRepository, CustomerRepository customerRepository, ChannelRepository channelRepository,
            PhoneRepository phoneRepository, PreferencesRepository preferencesRepository,
            Payment_Source_ConstraintRepository payment_Source_ConstraintRepository, PaypalRepository paypalRepository,
            VenmoRepository venmoRepository, Paypal_CreditRepository paypal_CreditRepository,
            Paypal_Pay_LaterRepository paypal_Pay_LaterRepository, Payment_TokensRepository payment_TokensRepository,
            Payment_Source_PaypalRepository payment_Source_PaypalRepository,
            Payment_Source_VenmoRepository payment_Source_VenmoRepository) {
        this.amountRepository = amountRepository;
        this.payment_InstructionRepository = payment_InstructionRepository;
        this.payeeRepository = payeeRepository;
        this.status_DetailsRepository = status_DetailsRepository;
        this.network_Transaction_ReferenceRepository = network_Transaction_ReferenceRepository;
        this.seller_ProtectionRepository = seller_ProtectionRepository;
        this.linksRepository = linksRepository;
        this.processor_ResponseRepository = processor_ResponseRepository;
        this.item_TotalRepository = item_TotalRepository;
        this.shippingRepository = shippingRepository;
        this.handlingRepository = handlingRepository;
        this.tax_TotalRepository = tax_TotalRepository;
        this.insuranceRepository = insuranceRepository;
        this.shipping_DiscountRepository = shipping_DiscountRepository;
        this.discountRepository = discountRepository;
        this.gross_AmountRepository = gross_AmountRepository;
        this.paypal_FeeRepository = paypal_FeeRepository;
        this.net_AmountRepository = net_AmountRepository;
        this.receivable_AmountRepository = receivable_AmountRepository;
        this.exchange_RateRepository = exchange_RateRepository;
        this.related_IdsRepository = related_IdsRepository;
        this.schemaRepository = schemaRepository;
        this.target_SchemaRepository = target_SchemaRepository;
        this.mediaRepository = mediaRepository;
        this.customerRepository = customerRepository;
        this.channelRepository = channelRepository;
        this.phoneRepository = phoneRepository;
        this.preferencesRepository = preferencesRepository;
        this.payment_Source_ConstraintRepository = payment_Source_ConstraintRepository;
        this.paypalRepository = paypalRepository;
        this.venmoRepository = venmoRepository;
        this.paypal_CreditRepository = paypal_CreditRepository;
        this.paypal_Pay_LaterRepository = paypal_Pay_LaterRepository;
        this.payment_TokensRepository = payment_TokensRepository;
        this.payment_Source_PaypalRepository = payment_Source_PaypalRepository;
        this.payment_Source_VenmoRepository = payment_Source_VenmoRepository;
    }
        

     /*     @Override
    public Capture_PaymentResponseDTO capture_Payment(String authorizationid, String PayPalRequestId, String Prefer,
            String Authorization, String PayPalAuthAssertion, Capture_PaymentRequestDTO capture_PaymentRequestDTO) {

                // Initialize DTO
                Capture_PaymentResponseDTO capture_PaymentResponseDTO = new Capture_PaymentResponseDTO();
                Payment_InstructionRequestDTO payment_InstructionRequestDTO =new Payment_InstructionRequestDTO();
                PayeeRequestDTO payeeRequestDTO = new PayeeRequestDTO();
                Status_DetailsResponseDTO status_DetailsResponseDTO = new Status_DetailsResponseDTO();
                AmountResponseDTO amountResponseDTO = new AmountResponseDTO();
                Network_Transaction_ReferenceResponseDTO network_Transaction_ReferenceResponseDTO = new Network_Transaction_ReferenceResponseDTO();
                Seller_ProtectionResponseDTO seller_ProtectionResponseDTO = new Seller_ProtectionResponseDTO();
                Seller_Receivable_BreakdownResponseDTO seller_Receivable_BreakdownResponseDTO = new Seller_Receivable_BreakdownResponseDTO();
                LinksResponseDTO linksResponseDTO = new LinksResponseDTO();
                Processor_ResponseResponseDTO processor_ResponseResponseDTO = new Processor_ResponseResponseDTO();
                Supplementary_DataResponseDTO supplementary_DataResponseDTO = new Supplementary_DataResponseDTO();
                PayeeResponseDTO payeeResponseDTO = new PayeeResponseDTO();
                BreakdownResponseDTO breakdownResponseDTO = new BreakdownResponseDTO();
                Item_TotalResponseDTO item_TotalResponseDTO = new Item_TotalResponseDTO();
                ShippingResponseDTO shippingResponseDTO = new ShippingResponseDTO();
                HandlingResponseDTO handlingResponseDTO = new HandlingResponseDTO();
                Tax_TotalResponseDTO tax_TotalResponseDTO = new Tax_TotalResponseDTO();
                InsuranceResponseDTO insuranceResponseDTO = new InsuranceResponseDTO();
                Shipping_DiscountResponseDTO shipping_DiscountResponseDTO = new Shipping_DiscountResponseDTO();
                DiscountResponseDTO discountResponseDTO = new DiscountResponseDTO();
                Seller_Receivable_BreakdownResponseDTO seller_Receivable_BreakdownResponseDTO2 = new Seller_Receivable_BreakdownResponseDTO();
                Gross_AmountResponseDTO gross_AmountResponseDTO = new Gross_AmountResponseDTO();
                Paypal_FeeResponseDTO paypal_FeeResponseDTO = new Paypal_FeeResponseDTO();
                Paypal_Fee_Receivable_CurrencyResponseDTO paypal_Fee_Receivable_CurrencyResponseDTO = new Paypal_Fee_Receivable_CurrencyResponseDTO();
                Net_AmountResponseDTO net_AmountResponseDTO = new Net_AmountResponseDTO();
                Receivable_AmountResponseDTO receivable_AmountResponseDTO = new Receivable_AmountResponseDTO();
                Exchange_RateResponseDTO exchange_RateResponseDTO = new Exchange_RateResponseDTO();
                Related_IdsResponseDTO related_IdsResponseDTO = new Related_IdsResponseDTO();
                Platform_FeesRequestDTO platform_FeesRequestDTO = new Platform_FeesRequestDTO();
                SchemaResponseDTO schemaResponseDTO = new SchemaResponseDTO();
                Target_SchemaResponseDTO target_SchemaResponseDTO = new Target_SchemaResponseDTO();
                MediaResponseDTO mediaResponseDTO = new MediaResponseDTO();
                

                
                
               


                // Initialize entities
                Amount amount = new Amount();
                Payee payee = new Payee();
                Item_Total item_Total = new Item_Total();
                Shipping shipping = new Shipping();
                Handling handling = new Handling();
                Tax_Total tax_Total = new Tax_Total();
                Insurance insurance = new Insurance();
                Shipping_Discount shipping_Discount = new Shipping_Discount();
                Discount discount = new Discount();
                Status_Details status_Details = new Status_Details();
                Network_Transaction_Reference network_Transaction_Reference = new Network_Transaction_Reference();
                Seller_Protection seller_Protection= new Seller_Protection();
                Gross_Amount gross_Amount = new Gross_Amount();
                Paypal_Fee paypal_Fee = new Paypal_Fee();
                Paypal_Fee_Receivable_Currency paypal_Fee_Receivable_Currency = new Paypal_Fee_Receivable_Currency();
                Net_Amount net_Amount = new Net_Amount();
                Receivable_Amount receivable_Amount = new Receivable_Amount();
                Exchange_Rate exchange_Rate = new Exchange_Rate();
                Processor_Response processor_Response = new Processor_Response();
                Related_Ids related_Ids = new Related_Ids();
                Links links = new Links();
                Schema schema = new Schema();
                Target_Schema target_Schema = new Target_Schema();
                Media media = new Media();
                

                


                // Get value To RequestDTO And Set to Value Entity
                //amount.setCurrency_code(amountRequestDTO.getCurrency_code());
                //amount.setValue(amountRequestDTO.getValue());
                //payment_Instruction.setDisbursement_mode(payment_InstructionRequestDTO.getDisbursement_mode());
                //payment_Instruction.setPayee_pricing_tier_id(payment_InstructionRequestDTO.getPayee_pricing_tier_id());
                //payment_Instruction.setPayee_receivable_fx_rate_id(payment_InstructionRequestDTO.getPayee_receivable_fx_rate_id());
               
                Payment_InstructionRequestDTO paymentInstruction = capture_PaymentRequestDTO.getPayment_instruction();

if (paymentInstruction != null) {
    paymentInstruction.setDisbursement_mode(paymentInstruction.getDisbursement_mode());
    paymentInstruction.setPayee_pricing_tier_id(paymentInstruction.getPayee_pricing_tier_id());
    paymentInstruction.setPayee_receivable_fx_rate_id(paymentInstruction.getPayee_receivable_fx_rate_id());
}

                AmountRequestDTO amountRequestDTO = capture_PaymentRequestDTO.getAmount();

if (amountRequestDTO != null) {
    amount.setCurrency_code(amountRequestDTO.getCurrency_code());
    amount.setValue(amountRequestDTO.getValue());
}

if (paymentInstruction != null) {

    List<Platform_FeesRequestDTO> platformFees = paymentInstruction.getPlatform_Fees();

    if (platformFees != null && !platformFees.isEmpty()) {

        for (Platform_FeesRequestDTO fee : platformFees) {

            if (fee.getAmount() != null) {
                amount.setCurrency_code(fee.getAmount().getCurrency_code());
                amount.setValue(fee.getAmount().getValue());
            }

            if (fee.getPayee() != null) {
                payee.setEmail_address(fee.getPayee().getEmail_address());
                payee.setMerchant_id(fee.getPayee().getMerchant_id());
            }
        }
    }
}


               amountRepository.save(amount);
               payeeRepository.save(payee);
               status_DetailsRepository.save(status_Details);
               network_Transaction_ReferenceRepository.save(network_Transaction_Reference);
               seller_ProtectionRepository.save(seller_Protection);
               linksRepository.save(links);
               processor_ResponseRepository.save(processor_Response);
               item_TotalRepository.save(item_Total);
               shippingRepository.save(shipping);
               handlingRepository.save(handling);
               tax_TotalRepository.save(tax_Total);
               insuranceRepository.save(insurance);
               shipping_DiscountRepository.save(shipping_Discount);
               discountRepository.save(discount);
               gross_AmountRepository.save(gross_Amount);
               paypal_FeeRepository.save(paypal_Fee);
               net_AmountRepository.save(net_Amount);
               receivable_AmountRepository.save(receivable_Amount);
               exchange_RateRepository.save(exchange_Rate);
               related_IdsRepository.save(related_Ids);
               schemaRepository.save(schema);
               target_SchemaRepository.save(target_Schema);
               mediaRepository.save(media);
               Payment_Instruction payment_Instruction = new Payment_Instruction();
paymentInstruction.setDisbursement_mode(payment_InstructionRequestDTO.getDisbursement_mode());
payment_InstructionRepository.save(payment_Instruction);
               

                // Get value To Entity And Se to value ResponseDTO
                status_DetailsResponseDTO.setReason(status_Details.getReason());
                amountResponseDTO.setCurrency_code(amount.getCurrency_code());
                amountResponseDTO.setValue(amount.getValue());
                item_TotalResponseDTO.setCurrency_code(item_Total.getCurrency_code());
                item_TotalResponseDTO.setValue(item_Total.getValue());
                shippingResponseDTO.setCurrency_code(shipping.getCurrency_code());
                shippingResponseDTO.setValue(shipping.getValue());
                handlingResponseDTO.setCurrency_code(handling.getCurrency_code());
                handlingResponseDTO.setValue(handling.getValue());
                tax_TotalResponseDTO.setCurrency_Code(tax_Total.getCurrency_code());
                tax_TotalResponseDTO.setValue(tax_Total.getValue());
                insuranceResponseDTO.setCurrency_code(insurance.getCurrency_code());
                insuranceResponseDTO.setValue(insurance.getValue());
                shipping_DiscountResponseDTO.setCurrency_code(shipping_Discount.getCurrency_code());
                shipping_DiscountResponseDTO.setValue(shipping_Discount.getValue());
                discountResponseDTO.setCurrency_code(discount.getCurrency_code());
                discountResponseDTO.setValue(discount.getValue());
                network_Transaction_ReferenceResponseDTO.setId(network_Transaction_Reference.getId());
                network_Transaction_ReferenceResponseDTO.setDate(network_Transaction_Reference.getDate());
                network_Transaction_ReferenceResponseDTO.setAcquirer_reference_number(network_Transaction_Reference.getAcquirer_reference_number());
                network_Transaction_ReferenceResponseDTO.setNetwork(network_Transaction_Reference.getNetwork());
                seller_ProtectionResponseDTO.setDispute_Categories(seller_Protection.getDispute_categories());
                seller_ProtectionResponseDTO.setStatus(seller_Protection.getStatus());
                gross_AmountResponseDTO.setCurrency_code(gross_Amount.getCurrency_code());
                gross_AmountResponseDTO.setValue(gross_Amount.getValue());
                paypal_FeeResponseDTO.setCurrency_code(paypal_Fee.getCurrency_code());
                paypal_FeeResponseDTO.setValue(paypal_Fee.getValue());
                paypal_Fee_Receivable_CurrencyResponseDTO.setCurrency_code(paypal_Fee_Receivable_Currency.getCurrency_code());
                paypal_Fee_Receivable_CurrencyResponseDTO.setValue(paypal_Fee_Receivable_Currency.getValue());
                net_AmountResponseDTO.setCurrency_code(net_Amount.getCurrency_code());
                net_AmountResponseDTO.setValue(net_Amount.getValue());
                receivable_AmountResponseDTO.setCurrency_code(receivable_Amount.getCurrency_code());
                receivable_AmountResponseDTO.setValue(receivable_Amount.getValue());
                exchange_RateResponseDTO.setSource_currency(exchange_Rate.getSource_currency());
                exchange_RateResponseDTO.setTarget_currency(exchange_Rate.getTarget_currency());
                exchange_RateResponseDTO.setValue(exchange_Rate.getValue());
                payeeResponseDTO.setEmail_address(payee.getEmail_address());
                payeeResponseDTO.setMerchant_id(payee.getMerchant_id());
                linksResponseDTO.setEncType(links.getEncType());
                linksResponseDTO.setHref(links.getHref());
                linksResponseDTO.setMediaType(links.getMediaType());
                linksResponseDTO.setMethod(links.getMethod());
                linksResponseDTO.setRel(links.getRel());
                linksResponseDTO.setTitle(links.getTitle());
                schemaResponseDTO.setAdditionalItems(schema.getAdditionalItems());
                schemaResponseDTO.setAllOf(schema.getAllOf());
                schemaResponseDTO.setAnyOf(schema.getAnyOf());
                schemaResponseDTO.setDefinitions(schema.getDefinitions());
                schemaResponseDTO.setFragmentResolution(schema.getFragmentResolution());
                schemaResponseDTO.setItems(schema.getItems());
                schemaResponseDTO.setLinks1(schema.getLinks1());
                schemaResponseDTO.setNotValue(schema.getNotValue());
                schemaResponseDTO.setOneOf(schema.getOneOf());
                schemaResponseDTO.setPathStart(schema.getPathStart());
                schemaResponseDTO.setPatternProperties(schema.getPatternProperties());
                schemaResponseDTO.setProperties(schema.getProperties());
                target_SchemaResponseDTO.setAdditionalItems(target_Schema.getAdditionalItems());
                target_SchemaResponseDTO.setAllOf(target_Schema.getAllOf());
                target_SchemaResponseDTO.setAnyOf(target_Schema.getAnyOf());
                target_SchemaResponseDTO.setDefinitions(target_Schema.getDefinitions());
                target_SchemaResponseDTO.setFragmentResolution(target_Schema.getFragmentResolution());
                target_SchemaResponseDTO.setItems(target_Schema.getItems());
                target_SchemaResponseDTO.setLinks1(target_Schema.getLinks1());
                target_SchemaResponseDTO.setNotValue(target_Schema.getNotValue());
                target_SchemaResponseDTO.setOneOf(target_Schema.getOneOf());
                target_SchemaResponseDTO.setPathStart(target_Schema.getPathStart());
                target_SchemaResponseDTO.setPatternProperties(target_Schema.getPatternProperties());
                target_SchemaResponseDTO.setProperties(target_Schema.getProperties());
                mediaResponseDTO.setType(media.getType());
                mediaResponseDTO.setBinaryEncoding(media.getBinaryEncoding());
                processor_ResponseResponseDTO.setAvs_code(processor_Response.getAvs_code());
                processor_ResponseResponseDTO.setCvv_code(processor_Response.getCvv_code());
                processor_ResponseResponseDTO.setPayment_advice_code(processor_Response.getPayment_advice_code());
                processor_ResponseResponseDTO.setResponse_code(processor_Response.getResponse_code());
                related_IdsResponseDTO.setAuthorization_id(related_Ids.getAuthorization_id());
                related_IdsResponseDTO.setCapture_id(related_Ids.getCapture_id());
                related_IdsResponseDTO.setOrder_id(related_Ids.getOrder_id());

                capture_PaymentResponseDTO.setAmount(amountResponseDTO);
                capture_PaymentResponseDTO.setNetwork_Transaction_Reference(network_Transaction_ReferenceResponseDTO);
                capture_PaymentResponseDTO.setPayee(payeeResponseDTO);
                capture_PaymentResponseDTO.setProcessor_Response(processor_ResponseResponseDTO);
                capture_PaymentResponseDTO.setSeller_Protection(seller_ProtectionResponseDTO);
                capture_PaymentResponseDTO.setStatus_Details(status_DetailsResponseDTO);
                capture_PaymentResponseDTO.setSupplementary_Data(supplementary_DataResponseDTO);
                capture_PaymentResponseDTO.setLinks(getAllLinks());
                capture_PaymentResponseDTO.getSeller_Protection();
                capture_PaymentResponseDTO.getSeller_Receivable_Breakdown();
                capture_PaymentResponseDTO.getSupplementary_Data();
                capture_PaymentResponseDTO.getStatus_Details();

                
                return capture_PaymentResponseDTO;
                

                
                


    } */
    
    
    
  
   // Initialize List Get value To Entity And Se to value ResponseDTO
   @Override
    public List<LinksResponseDTO> getAllLinks() {

        List<Links> linksList = linksRepository.findAll();

        return linksList.stream().map(links -> {

            LinksResponseDTO linksResponseDTO = new LinksResponseDTO();

            linksResponseDTO.setHref(links.getHref());
            linksResponseDTO.setRel(links.getRel());
            linksResponseDTO.setMethod(links.getMethod());
            linksResponseDTO.setTitle(links.getTitle());
            linksResponseDTO.setMediaType(links.getMediaType());
            linksResponseDTO.setEncType(links.getEncType());

            // Schema Mapping
            if (links.getSchema() != null) {

                SchemaResponseDTO schemaResponseDTO = new SchemaResponseDTO();

                schemaResponseDTO.setAdditionalItems(links.getSchema().getAdditionalItems());
                schemaResponseDTO.setItems(links.getSchema().getItems());
                schemaResponseDTO.setDefinitions(links.getSchema().getDefinitions());
                schemaResponseDTO.setPatternProperties(links.getSchema().getPatternProperties());
                schemaResponseDTO.setProperties(links.getSchema().getProperties());
                schemaResponseDTO.setAllOf(links.getSchema().getAllOf());
                schemaResponseDTO.setAnyOf(links.getSchema().getAnyOf());
                schemaResponseDTO.setOneOf(links.getSchema().getOneOf());
                schemaResponseDTO.setNotValue(links.getSchema().getNotValue());
                schemaResponseDTO.setLinks1(links.getSchema().getLinks1());
                schemaResponseDTO.setFragmentResolution(links.getSchema().getFragmentResolution());
                schemaResponseDTO.setPathStart(links.getSchema().getPathStart());

                linksResponseDTO.setSchema(schemaResponseDTO);
            }

            // Target Schema Mapping
            if (links.getTarget_Schema() != null) {

                Target_SchemaResponseDTO target_SchemaResponseDTO = new Target_SchemaResponseDTO();

                target_SchemaResponseDTO.setAdditionalItems(links.getTarget_Schema().getAdditionalItems());
                target_SchemaResponseDTO.setItems(links.getTarget_Schema().getItems());
                target_SchemaResponseDTO.setDefinitions(links.getTarget_Schema().getDefinitions());
                target_SchemaResponseDTO.setPatternProperties(links.getTarget_Schema().getPatternProperties());
                target_SchemaResponseDTO.setProperties(links.getTarget_Schema().getProperties());
                target_SchemaResponseDTO.setAllOf(links.getTarget_Schema().getAllOf());
                target_SchemaResponseDTO.setAnyOf(links.getTarget_Schema().getAnyOf());
                target_SchemaResponseDTO.setOneOf(links.getTarget_Schema().getOneOf());
                target_SchemaResponseDTO.setNotValue(links.getTarget_Schema().getNotValue());
                target_SchemaResponseDTO.setLinks1(links.getTarget_Schema().getLinks1());
                target_SchemaResponseDTO.setFragmentResolution(links.getTarget_Schema().getFragmentResolution());
                target_SchemaResponseDTO.setPathStart(links.getTarget_Schema().getPathStart());

                linksResponseDTO.setTarget_Schema(target_SchemaResponseDTO);
            }

            return linksResponseDTO;

        }).collect(Collectors.toList());
    }





  













  
   

      
              /*   @Override
                public Reauthorize_PaymentResponseDTO reauthorize_Payment(String authorizationid,
                        String PayPalRequestId, String Prefer, String Authorization, String PayPalAuthAssertion,
                        Reauthorize_PaymentRequestDTO reauthorize_PaymentRequestDTO) {
                   



                // Initialize DTO
                Reauthorize_PaymentResponseDTO reauthorize_PaymentResponseDTO = new Reauthorize_PaymentResponseDTO();
                Status_DetailsResponseDTO status_DetailsResponseDTO = new Status_DetailsResponseDTO();
                AmountResponseDTO amountResponseDTO = new AmountResponseDTO();
                BreakdownResponseDTO breakdownResponseDTO = new BreakdownResponseDTO();
                Item_TotalResponseDTO item_TotalResponseDTO = new Item_TotalResponseDTO();
                ShippingResponseDTO shippingResponseDTO = new ShippingResponseDTO();
                HandlingResponseDTO handlingResponseDTO = new HandlingResponseDTO();
                Tax_TotalResponseDTO tax_TotalResponseDTO = new Tax_TotalResponseDTO();
                InsuranceResponseDTO insuranceResponseDTO = new InsuranceResponseDTO();
                Shipping_DiscountResponseDTO shipping_DiscountResponseDTO = new Shipping_DiscountResponseDTO();
                DiscountResponseDTO discountResponseDTO = new DiscountResponseDTO();
                Network_Transaction_ReferenceResponseDTO network_Transaction_ReferenceResponseDTO = new Network_Transaction_ReferenceResponseDTO();
                Seller_ProtectionResponseDTO seller_ProtectionResponseDTO = new Seller_ProtectionResponseDTO();
                LinksResponseDTO linksResponseDTO = new LinksResponseDTO();
                SchemaResponseDTO schemaResponseDTO = new SchemaResponseDTO();
                Target_SchemaResponseDTO target_SchemaResponseDTO = new Target_SchemaResponseDTO();
                MediaResponseDTO mediaResponseDTO = new MediaResponseDTO();
                Supplementary_DataResponseDTO supplementary_DataResponseDTO = new Supplementary_DataResponseDTO();
                Related_IdsResponseDTO related_IdsResponseDTO = new Related_IdsResponseDTO();
                PayeeResponseDTO payeeResponseDTO = new PayeeResponseDTO();
                AmountRequestDTO amountRequestDTO = reauthorize_PaymentRequestDTO.getAmount();

                // Initialize entities
                Amount amount = new Amount();
                Status_Details status_Details = new Status_Details();
                Item_Total item_Total = new Item_Total();
                Shipping shipping = new Shipping();
                Handling handling = new Handling();
                Tax_Total tax_Total = new Tax_Total();
                Insurance insurance = new Insurance();
                Shipping_Discount shipping_Discount = new Shipping_Discount();
                Discount discount = new Discount();
                Network_Transaction_Reference network_Transaction_Reference = new Network_Transaction_Reference();
                Seller_Protection seller_Protection = new Seller_Protection();
                Links links = new Links();
                Schema schema = new Schema();
                Target_Schema target_Schema = new Target_Schema();
                Media media = new Media();
                Related_Ids related_Ids = new Related_Ids();
                Payee payee = new Payee();


                //amount.setCurrency_code(amountRequestDTO.getCurrency_code());
                //amount.setValue(amountRequestDTO.getValue());

                amount.setCurrency_code(amountRequestDTO.getCurrency_code());
                amount.setValue(amountRequestDTO.getValue());

               if (amountRequestDTO != null) {
                amountRepository.save(amount);
                   }

                amountRepository.save(amount);
                status_DetailsRepository.save(status_Details);
                item_TotalRepository.save(item_Total);
                shippingRepository.save(shipping);
                handlingRepository.save(handling);
                tax_TotalRepository.save(tax_Total);
                insuranceRepository.save(insurance);
                shipping_DiscountRepository.save(shipping_Discount);
                discountRepository.save(discount);
                network_Transaction_ReferenceRepository.save(network_Transaction_Reference);
                seller_ProtectionRepository.save(seller_Protection);
                linksRepository.save(links);
                schemaRepository.save(schema);
                target_SchemaRepository.save(target_Schema);
                mediaRepository.save(media);
                related_IdsRepository.save(related_Ids);
                payeeRepository.save(payee);



                amountResponseDTO.setCurrency_code(amount.getCurrency_code());
                amountResponseDTO.setValue(amount.getValue());
                status_DetailsResponseDTO.setReason(status_Details.getReason());
                item_TotalResponseDTO.setCurrency_code(item_Total.getCurrency_code());
                item_TotalResponseDTO.setValue(item_Total.getValue());
                shippingResponseDTO.setCurrency_code(shipping.getCurrency_code());
                shippingResponseDTO.setValue(shipping.getValue());
                handlingResponseDTO.setCurrency_code(handling.getCurrency_code());
                handlingResponseDTO.setValue(handling.getValue());
                tax_TotalResponseDTO.setCurrency_Code(tax_Total.getCurrency_code());
                tax_TotalResponseDTO.setValue(tax_Total.getValue());
                insuranceResponseDTO.setCurrency_code(insurance.getCurrency_code());
                insuranceResponseDTO.setValue(insurance.getValue());
                shipping_DiscountResponseDTO.setCurrency_code(shipping_Discount.getCurrency_code());
                shipping_DiscountResponseDTO.setValue(shipping_Discount.getValue());
                discountResponseDTO.setCurrency_code(discount.getCurrency_code());
                discountResponseDTO.setValue(discount.getValue());
                network_Transaction_ReferenceResponseDTO.setId(network_Transaction_Reference.getId());
                network_Transaction_ReferenceResponseDTO.setDate(network_Transaction_Reference.getDate());
                network_Transaction_ReferenceResponseDTO.setNetwork(network_Transaction_Reference.getNetwork());
                network_Transaction_ReferenceResponseDTO.setAcquirer_reference_number(network_Transaction_Reference.getAcquirer_reference_number());
                seller_ProtectionResponseDTO.setStatus(seller_Protection.getStatus());
                seller_ProtectionResponseDTO.setDispute_Categories(seller_Protection.getDispute_categories());
                linksResponseDTO.setEncType(links.getEncType());
                linksResponseDTO.setHref(links.getHref());
                linksResponseDTO.setMediaType(links.getMediaType());
                linksResponseDTO.setMethod(links.getMethod());
                linksResponseDTO.setRel(links.getRel());
                linksResponseDTO.setTitle(links.getTitle());
                schemaResponseDTO.setAdditionalItems(schema.getAdditionalItems());
                schemaResponseDTO.setAllOf(schema.getAllOf());
                schemaResponseDTO.setAnyOf(schema.getAnyOf());
                schemaResponseDTO.setDefinitions(schema.getDefinitions());
                schemaResponseDTO.setFragmentResolution(schema.getFragmentResolution());
                schemaResponseDTO.setItems(schema.getItems());
                schemaResponseDTO.setLinks1(schema.getLinks1());
                schemaResponseDTO.setNotValue(schema.getNotValue());
                schemaResponseDTO.setOneOf(schema.getOneOf());
                schemaResponseDTO.setPathStart(schema.getPathStart());
                schemaResponseDTO.setPatternProperties(schema.getPatternProperties());
                schemaResponseDTO.setProperties(schema.getProperties());
                target_SchemaResponseDTO.setAdditionalItems(target_Schema.getAdditionalItems());
                target_SchemaResponseDTO.setAllOf(target_Schema.getAllOf());
                target_SchemaResponseDTO.setAnyOf(target_Schema.getAnyOf());
                target_SchemaResponseDTO.setDefinitions(target_Schema.getDefinitions());
                target_SchemaResponseDTO.setFragmentResolution(target_Schema.getFragmentResolution());
                target_SchemaResponseDTO.setItems(target_Schema.getItems());
                target_SchemaResponseDTO.setLinks1(target_Schema.getLinks1());
                target_SchemaResponseDTO.setNotValue(target_Schema.getNotValue());
                target_SchemaResponseDTO.setOneOf(target_Schema.getOneOf());
                target_SchemaResponseDTO.setPathStart(target_Schema.getPathStart());
                target_SchemaResponseDTO.setPatternProperties(target_Schema.getPatternProperties());
                target_SchemaResponseDTO.setProperties(target_Schema.getProperties());
                mediaResponseDTO.setType(media.getType());
                mediaResponseDTO.setBinaryEncoding(media.getBinaryEncoding());
                related_IdsResponseDTO.setAuthorization_id(related_Ids.getAuthorization_id());
                related_IdsResponseDTO.setCapture_id(related_Ids.getCapture_id());
                related_IdsResponseDTO.setOrder_id(related_Ids.getOrder_id());
                payeeResponseDTO.setEmail_address(payee.getEmail_address());
                payeeResponseDTO.setMerchant_id(payee.getMerchant_id());              
                
                reauthorize_PaymentResponseDTO.setAmount(amountResponseDTO);
                reauthorize_PaymentResponseDTO.setLinks(getAllLinks());
                reauthorize_PaymentResponseDTO.setNetwork_Transaction_Reference(network_Transaction_ReferenceResponseDTO);
                reauthorize_PaymentResponseDTO.setPayee(payeeResponseDTO);
                reauthorize_PaymentResponseDTO.setSeller_Protection(seller_ProtectionResponseDTO);
                reauthorize_PaymentResponseDTO.setStatus_Details(status_DetailsResponseDTO);
                reauthorize_PaymentResponseDTO.getSupplementary_Data();
                reauthorize_PaymentResponseDTO.getStatus_Details();
                return reauthorize_PaymentResponseDTO;

                
    }*/




              

     

     

    
      /*    @Override
    public Authorized_PaymentResponseDTO authorized_Payment(String authorization_id, String Authorization,
            String PayPalAuthAssertion, String PayPalRequestId, String Prefer,
            Authorized_PaymentRequestDTO authorized_PaymentRequestDTO) {
                Authorized_PaymentResponseDTO authorized_PaymentResponseDTO = new Authorized_PaymentResponseDTO();
                Status_DetailsResponseDTO status_DetailsResponseDTO = new Status_DetailsResponseDTO();
                AmountResponseDTO amountResponseDTO = new AmountResponseDTO();
                BreakdownResponseDTO breakdownResponseDTO = new BreakdownResponseDTO();
                Item_TotalResponseDTO item_TotalResponseDTO = new Item_TotalResponseDTO();
                ShippingResponseDTO shippingResponseDTO = new ShippingResponseDTO();
                HandlingResponseDTO handlingResponseDTO = new HandlingResponseDTO();
                Tax_TotalResponseDTO tax_TotalResponseDTO = new Tax_TotalResponseDTO();
                InsuranceResponseDTO insuranceResponseDTO = new InsuranceResponseDTO();
                Shipping_DiscountResponseDTO shipping_DiscountResponseDTO = new Shipping_DiscountResponseDTO();
                DiscountResponseDTO discountResponseDTO = new DiscountResponseDTO();
                Network_Transaction_ReferenceResponseDTO network_Transaction_ReferenceResponseDTO = new Network_Transaction_ReferenceResponseDTO();
                Seller_ProtectionResponseDTO seller_ProtectionResponseDTO = new Seller_ProtectionResponseDTO();
                LinksResponseDTO linksResponseDTO = new LinksResponseDTO();
                SchemaResponseDTO schemaResponseDTO = new SchemaResponseDTO();
                Target_SchemaResponseDTO target_SchemaResponseDTO = new Target_SchemaResponseDTO();
                MediaResponseDTO mediaResponseDTO = new MediaResponseDTO();
                Supplementary_DataResponseDTO supplementary_DataResponseDTO = new Supplementary_DataResponseDTO();
                Related_IdsResponseDTO related_IdsResponseDTO = new Related_IdsResponseDTO();
                PayeeResponseDTO payeeResponseDTO = new PayeeResponseDTO();


                // Initialize entities
                Status_Details status_Details = new Status_Details();
                Amount amount = new Amount();
                Item_Total item_Total = new Item_Total();
                Shipping shipping = new Shipping();
                Handling handling = new Handling();
                Tax_Total tax_Total = new Tax_Total();
                Insurance insurance = new Insurance();
                Shipping_Discount shipping_Discount = new Shipping_Discount();
                Discount discount = new Discount();
                Network_Transaction_Reference network_Transaction_Reference = new Network_Transaction_Reference();
                Seller_Protection seller_Protection = new Seller_Protection();
                Links links = new Links();
                Schema schema = new Schema();
                Target_Schema target_Schema = new Target_Schema();
                Media media = new Media();
                Related_Ids related_Ids = new Related_Ids();
                Payee payee = new Payee();

                status_DetailsRepository.save(status_Details);
                amountRepository.save(amount);
                item_TotalRepository.save(item_Total);
                shippingRepository.save(shipping);
                handlingRepository.save(handling);
                tax_TotalRepository.save(tax_Total);
                insuranceRepository.save(insurance);
                shipping_DiscountRepository.save(shipping_Discount);
                discountRepository.save(discount);
                network_Transaction_ReferenceRepository.save(network_Transaction_Reference);
                seller_ProtectionRepository.save(seller_Protection);
                linksRepository.save(links);
                schemaRepository.save(schema);
                target_SchemaRepository.save(target_Schema);
                mediaRepository.save(media);
                related_IdsRepository.save(related_Ids);
                payeeRepository.save(payee);

                status_DetailsResponseDTO.setReason(status_Details.getReason());
                amountResponseDTO.setCurrency_code(amount.getCurrency_code());
                amountResponseDTO.setValue(amount.getValue());
                item_TotalResponseDTO.setCurrency_code(item_Total.getCurrency_code());
                item_TotalResponseDTO.setValue(item_Total.getValue());
                shippingResponseDTO.setCurrency_code(shipping.getCurrency_code());
                shippingResponseDTO.setValue(shipping.getValue());
                handlingResponseDTO.setCurrency_code(handling.getCurrency_code());
                handlingResponseDTO.setValue(handling.getValue());
                tax_TotalResponseDTO.setCurrency_Code(tax_Total.getCurrency_code());
                tax_TotalResponseDTO.setValue(tax_Total.getValue());
                insuranceResponseDTO.setCurrency_code(insurance.getCurrency_code());
                insuranceResponseDTO.setValue(insurance.getValue());
                shipping_DiscountResponseDTO.setCurrency_code(shipping_Discount.getCurrency_code());
                shipping_DiscountResponseDTO.setValue(shipping_Discount.getValue());
                discountResponseDTO.setCurrency_code(discount.getCurrency_code());
                discountResponseDTO.setValue(discount.getValue());
                network_Transaction_ReferenceResponseDTO.setId(network_Transaction_Reference.getId());
                network_Transaction_ReferenceResponseDTO.setDate(network_Transaction_Reference.getDate());
                network_Transaction_ReferenceResponseDTO.setNetwork(network_Transaction_Reference.getNetwork());
                network_Transaction_ReferenceResponseDTO.setAcquirer_reference_number(network_Transaction_Reference.getAcquirer_reference_number());
                seller_ProtectionResponseDTO.setStatus(seller_Protection.getStatus());
                seller_ProtectionResponseDTO.setDispute_Categories(seller_Protection.getDispute_categories());
                linksResponseDTO.setEncType(links.getEncType());
                linksResponseDTO.setHref(links.getHref());
                linksResponseDTO.setMediaType(links.getMediaType());
                linksResponseDTO.setMethod(links.getMethod());
                linksResponseDTO.setRel(links.getRel());
                linksResponseDTO.setTitle(links.getTitle());
                schemaResponseDTO.setAdditionalItems(schema.getAdditionalItems());
                schemaResponseDTO.setAllOf(schema.getAllOf());
                schemaResponseDTO.setAnyOf(schema.getAnyOf());
                schemaResponseDTO.setDefinitions(schema.getDefinitions());
                schemaResponseDTO.setFragmentResolution(schema.getFragmentResolution());
                schemaResponseDTO.setItems(schema.getItems());
                schemaResponseDTO.setLinks1(schema.getLinks1());
                schemaResponseDTO.setNotValue(schema.getNotValue());
                schemaResponseDTO.setOneOf(schema.getOneOf());
                schemaResponseDTO.setPathStart(schema.getPathStart());
                schemaResponseDTO.setPatternProperties(schema.getPatternProperties());
                schemaResponseDTO.setProperties(schema.getProperties());
                target_SchemaResponseDTO.setAdditionalItems(target_Schema.getAdditionalItems());
                target_SchemaResponseDTO.setAllOf(target_Schema.getAllOf());
                target_SchemaResponseDTO.setAnyOf(target_Schema.getAnyOf());
                target_SchemaResponseDTO.setDefinitions(target_Schema.getDefinitions());
                target_SchemaResponseDTO.setFragmentResolution(target_Schema.getFragmentResolution());
                target_SchemaResponseDTO.setItems(target_Schema.getItems());
                target_SchemaResponseDTO.setLinks1(target_Schema.getLinks1());
                target_SchemaResponseDTO.setNotValue(target_Schema.getNotValue());
                target_SchemaResponseDTO.setOneOf(target_Schema.getOneOf());
                target_SchemaResponseDTO.setPathStart(target_Schema.getPathStart());
                target_SchemaResponseDTO.setPatternProperties(target_Schema.getPatternProperties());
                target_SchemaResponseDTO.setProperties(target_Schema.getProperties());
                mediaResponseDTO.setType(media.getType());
                mediaResponseDTO.setBinaryEncoding(media.getBinaryEncoding());
                related_IdsResponseDTO.setAuthorization_id(related_Ids.getAuthorization_id());
                related_IdsResponseDTO.setCapture_id(related_Ids.getCapture_id());
                related_IdsResponseDTO.setOrder_id(related_Ids.getOrder_id());
                payeeResponseDTO.setEmail_address(payee.getEmail_address());
                payeeResponseDTO.setMerchant_id(payee.getMerchant_id());   

                authorized_PaymentResponseDTO.setStatus_details(status_DetailsResponseDTO);
                authorized_PaymentResponseDTO.setAmount(amountResponseDTO);
                authorized_PaymentResponseDTO.setNetwork_transaction_reference(network_Transaction_ReferenceResponseDTO);
                authorized_PaymentResponseDTO.setSeller_protection(seller_ProtectionResponseDTO);
                authorized_PaymentResponseDTO.setLinks(getAllLinks());
                authorized_PaymentResponseDTO.setSupplementary_Data(supplementary_DataResponseDTO);
                authorized_PaymentResponseDTO.setPayee(payeeResponseDTO);
                authorized_PaymentResponseDTO.getStatus_details();
                authorized_PaymentResponseDTO.getSeller_protection();
                authorized_PaymentResponseDTO.getSupplementary_Data();

                return authorized_PaymentResponseDTO;





        
    } */





       



     




    

   /*  @Override
    public Show_Captured_PaymentResponseDTO show_Captured_Payment(String captureid, String Authorization) {
        
    } */

   /*  @Override
    public Refund_Captured_PaymentResponseDTO refund_Captured_Payment(String captureid, String PayPalRequestId,
            String Prefer, String Authorization, String PayPalAuthAssertion,
            Refund_Captured_PaymentRequestDTO refund_Captured_PaymentRequestDTO) {
                AmountRequestDTO amountRequestDTO = new AmountRequestDTO();
                Payment_InstructionRequestDTO payment_InstructionRequestDTO = new Payment_InstructionRequestDTO();
                Status_DetailsResponseDTO status_DetailsResponseDTO = new Status_DetailsResponseDTO();
                AmountResponseDTO amountResponseDTO = new AmountResponseDTO();
                Seller_Payable_BreakdownResponseDTO seller_Payable_BreakdownResponseDTO = new Seller_Payable_BreakdownResponseDTO();
                PayerResponseDTO payerResponseDTO = new PayerResponseDTO();
                LinksResponseDTO linksResponseDTO = new LinksResponseDTO();

                // Initialize entities
                Amount amount = new Amount();
                Payee payee = new Payee();


                amount.setCurrency_code(amountRequestDTO.getCurrency_code());
                amount.setValue( amountRequestDTO.getValue());
                amount.setCurrency_code(payment_InstructionRequestDTO.getPlatform_Fees().getAmount().getCurrency_code());
                amount.setValue(payment_InstructionRequestDTO.getPlatform_Fees().getAmount().getValue());
                payee.setEmail_address(payment_InstructionRequestDTO.getPlatform_Fees().getPayee().getEmail_address());
                payee.setMerchant_id(payment_InstructionRequestDTO.getPlatform_Fees().getPayee().getMerchant_id());





        
    }*/

      /**
     * @param Authorization
     * @param PayPalAuthAssertion
     * @param UserAgent
     * @param PayPalClientMetadataId
     * @param list_Eligible_PaymentRequestDTO
     * @return
     */
    @Override
    public List_Eligible_PaymentResponseDTO list_Eligible_Payment(String Authorization, String PayPalAuthAssertion,
            String UserAgent, String PayPalClientMetadataId,
            List_Eligible_PaymentRequestDTO list_Eligible_PaymentRequestDTO) {
                // Initialize DTO
                List_Eligible_PaymentResponseDTO list_Eligible_PaymentResponseDTO = new List_Eligible_PaymentResponseDTO();
                CustomerRequestDTO customerRequestDTO = new CustomerRequestDTO();
                ChannelRequestDTO channelRequestDTO = new ChannelRequestDTO();
                PhoneRequestDTO phoneRequestDTO = new PhoneRequestDTO();
                Purchase_UnitsRequestDTO purchase_UnitsRequestDTO = new Purchase_UnitsRequestDTO();
                AmountRequestDTO amountRequestDTO = new AmountRequestDTO();
                BreakdownRequestDTO breakdownRequestDTO = new BreakdownRequestDTO();
                Item_TotalRequestDTO item_TotalRequestDTO = new Item_TotalRequestDTO();
                ShippingRequestDTO shippingRequestDTO = new ShippingRequestDTO();
                HandlingRequestDTO handlingRequestDTO = new HandlingRequestDTO();
                Tax_TotalRequestDTO tax_TotalRequestDTO = new Tax_TotalRequestDTO();
                InsuranceRequestDTO insuranceRequestDTO = new InsuranceRequestDTO();
                Shipping_DiscountRequestDTO shipping_DiscountRequestDTO = new Shipping_DiscountRequestDTO();
                DiscountRequestDTO discountRequestDTO = new DiscountRequestDTO();
                PayeeRequestDTO payeeRequestDTO = new PayeeRequestDTO();
                PreferencesRequestDTO preferencesRequestDTO = new PreferencesRequestDTO();
                Payment_Source_ConstraintRequestDTO payment_Source_ConstraintRequestDTO = new Payment_Source_ConstraintRequestDTO();
                Eligible_MethodsResponseDTO eligible_MethodsResponseDTO = new Eligible_MethodsResponseDTO();
                PaypalResponseDTO paypalResponseDTO = new PaypalResponseDTO();
                VenmoResponseDTO venmoResponseDTO = new VenmoResponseDTO();
                Paypal_CreditResponseDTO paypal_CreditResponseDTO = new Paypal_CreditResponseDTO();
                Paypal_Pay_LaterResponseDTO paypal_Pay_LaterResponseDTO = new Paypal_Pay_LaterResponseDTO();
                Payment_TokensResponseDTO payment_TokensResponseDTO = new Payment_TokensResponseDTO();
                Payment_SourceResponseDTO payment_SourceResponseDTO = new Payment_SourceResponseDTO();
                Payment_Source_PaypalResponseDTO payment_Source_PaypalResponseDTO = new Payment_Source_PaypalResponseDTO();
                Payment_Source_VenmoResponseDTO payment_Source_VenmoResponseDTO = new Payment_Source_VenmoResponseDTO();
                LinksResponseDTO linksResponseDTO = new LinksResponseDTO();
                SchemaResponseDTO schemaResponseDTO = new SchemaResponseDTO();
                Target_SchemaResponseDTO target_SchemaResponseDTO = new Target_SchemaResponseDTO();
                MediaResponseDTO mediaResponseDTO = new MediaResponseDTO();

                // Initialize entities
                Customer customer = new Customer();
                try (Channel channel = new Channel() {

                    @Override
                    public boolean isOpen() {
                        // TODO Auto-generated method stub
                        throw new UnsupportedOperationException("Unimplemented method 'isOpen'");
                    }

                    @Override
                    public void close() throws IOException {
                        // TODO Auto-generated method stub
                        throw new UnsupportedOperationException("Unimplemented method 'close'");
                    }
                    
                }) {
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                Phone phone = new Phone();
                Amount amount = new Amount();
                Item_Total item_Total = new Item_Total();
                Shipping shipping = new Shipping();
                Handling handling = new Handling();
                Tax_Total tax_Total = new Tax_Total();
                Insurance insurance = new Insurance();
                Shipping_Discount shipping_Discount = new Shipping_Discount();
                Discount discount = new Discount();
                Payee payee = new Payee();
                final Preferences preferences = new Preferences() {
                   

                    @Override
                    public void put(String key, String value) {
                        // TODO Auto-generated method stub
                        throw new UnsupportedOperationException("Unimplemented method 'put'");
                    }

                    @Override
                    public String get(String key, String def) {
                        // TODO Auto-generated method stub
                        throw new UnsupportedOperationException("Unimplemented method 'get'");
                    }

                    @Override
                    public void remove(String key) {
                        // TODO Auto-generated method stub
                        throw new UnsupportedOperationException("Unimplemented method 'remove'");
                    }

                    @Override
                    public void clear() throws BackingStoreException {
                        // TODO Auto-generated method stub
                        throw new UnsupportedOperationException("Unimplemented method 'clear'");
                    }

                    @Override
                    public void putInt(String key, int value) {
                        // TODO Auto-generated method stub
                        throw new UnsupportedOperationException("Unimplemented method 'putInt'");
                    }

                    @Override
                    public int getInt(String key, int def) {
                        // TODO Auto-generated method stub
                        throw new UnsupportedOperationException("Unimplemented method 'getInt'");
                    }

                    @Override
                    public void putLong(String key, long value) {
                        // TODO Auto-generated method stub
                        throw new UnsupportedOperationException("Unimplemented method 'putLong'");
                    }

                    @Override
                    public long getLong(String key, long def) {
                        // TODO Auto-generated method stub
                        throw new UnsupportedOperationException("Unimplemented method 'getLong'");
                    }

                    @Override
                    public void putBoolean(String key, boolean value) {
                        // TODO Auto-generated method stub
                        throw new UnsupportedOperationException("Unimplemented method 'putBoolean'");
                    }

                    @Override
                    public boolean getBoolean(String key, boolean def) {
                        // TODO Auto-generated method stub
                        throw new UnsupportedOperationException("Unimplemented method 'getBoolean'");
                    }

                    @Override
                    public void putFloat(String key, float value) {
                        // TODO Auto-generated method stub
                        throw new UnsupportedOperationException("Unimplemented method 'putFloat'");
                    }

                    @Override
                    public float getFloat(String key, float def) {
                        // TODO Auto-generated method stub
                        throw new UnsupportedOperationException("Unimplemented method 'getFloat'");
                    }

                    @Override
                    public void putDouble(String key, double value) {
                        // TODO Auto-generated method stub
                        throw new UnsupportedOperationException("Unimplemented method 'putDouble'");
                    }

                    @Override
                    public double getDouble(String key, double def) {
                        // TODO Auto-generated method stub
                        throw new UnsupportedOperationException("Unimplemented method 'getDouble'");
                    }

                    @Override
                    public void putByteArray(String key, byte[] value) {
                        // TODO Auto-generated method stub
                        throw new UnsupportedOperationException("Unimplemented method 'putByteArray'");
                    }

                    @Override
                    public byte[] getByteArray(String key, byte[] def) {
                        // TODO Auto-generated method stub
                        throw new UnsupportedOperationException("Unimplemented method 'getByteArray'");
                    }

                    @Override
                    public String[] keys() throws BackingStoreException {
                        // TODO Auto-generated method stub
                        throw new UnsupportedOperationException("Unimplemented method 'keys'");
                    }

                    @Override
                    public String[] childrenNames() throws BackingStoreException {
                        // TODO Auto-generated method stub
                        throw new UnsupportedOperationException("Unimplemented method 'childrenNames'");
                    }

                    @Override
                    public Preferences parent() {
                        // TODO Auto-generated method stub
                        throw new UnsupportedOperationException("Unimplemented method 'parent'");
                    }

                    @Override
                    public Preferences node(String pathName) {
                        // TODO Auto-generated method stub
                        throw new UnsupportedOperationException("Unimplemented method 'node'");
                    }

                    @Override
                    public boolean nodeExists(String pathName) throws BackingStoreException {
                        // TODO Auto-generated method stub
                        throw new UnsupportedOperationException("Unimplemented method 'nodeExists'");
                    }

                    @Override
                    public void removeNode() throws BackingStoreException {
                        // TODO Auto-generated method stub
                        throw new UnsupportedOperationException("Unimplemented method 'removeNode'");
                    }

                    @Override
                    public String name() {
                        // TODO Auto-generated method stub
                        throw new UnsupportedOperationException("Unimplemented method 'name'");
                    }

                    @Override
                    public String absolutePath() {
                        // TODO Auto-generated method stub
                        throw new UnsupportedOperationException("Unimplemented method 'absolutePath'");
                    }

                    @Override
                    public boolean isUserNode() {
                        // TODO Auto-generated method stub
                        throw new UnsupportedOperationException("Unimplemented method 'isUserNode'");
                    }

                    @Override
                    public String toString() {
                        // TODO Auto-generated method stub
                        throw new UnsupportedOperationException("Unimplemented method 'toString'");
                    }

                    @Override
                    public void flush() throws BackingStoreException {
                        // TODO Auto-generated method stub
                        throw new UnsupportedOperationException("Unimplemented method 'flush'");
                    }

                    @Override
                    public void sync() throws BackingStoreException {
                        // TODO Auto-generated method stub
                        throw new UnsupportedOperationException("Unimplemented method 'sync'");
                    }

                    @Override
                    public void addPreferenceChangeListener(PreferenceChangeListener pcl) {
                        // TODO Auto-generated method stub
                        throw new UnsupportedOperationException("Unimplemented method 'addPreferenceChangeListener'");
                    }

                    @Override
                    public void removePreferenceChangeListener(PreferenceChangeListener pcl) {
                        // TODO Auto-generated method stub
                        throw new UnsupportedOperationException("Unimplemented method 'removePreferenceChangeListener'");
                    }

                    @Override
                    public void addNodeChangeListener(NodeChangeListener ncl) {
                        // TODO Auto-generated method stub
                        throw new UnsupportedOperationException("Unimplemented method 'addNodeChangeListener'");
                    }

                    @Override
                    public void removeNodeChangeListener(NodeChangeListener ncl) {
                        // TODO Auto-generated method stub
                        throw new UnsupportedOperationException("Unimplemented method 'removeNodeChangeListener'");
                    }

                    @Override
                    public void exportNode(OutputStream os) throws IOException, BackingStoreException {
                        // TODO Auto-generated method stub
                        throw new UnsupportedOperationException("Unimplemented method 'exportNode'");
                    }

                    @Override
                    public void exportSubtree(OutputStream os) throws IOException, BackingStoreException {
                        // TODO Auto-generated method stub
                        throw new UnsupportedOperationException("Unimplemented method 'exportSubtree'");
                    }
                };
                Payment_Source_Constraint payment_Source_Constraint = new Payment_Source_Constraint();
                Paypal paypal = new Paypal();
                Venmo venmo = new Venmo();
                Paypal_Credit paypal_Credit = new Paypal_Credit();
                Paypal_Pay_Later paypal_Pay_Later = new Paypal_Pay_Later();
                Payment_Tokens payment_Tokens = new Payment_Tokens();
                Payment_Source_Paypal payment_Source_Paypal = new Payment_Source_Paypal();
                Payment_Source_Venmo payment_Source_Venmo = new Payment_Source_Venmo();
                Links links = new Links();
                
               
                
                

                
                

        

                
        
    }

    /* @Override
    public Show_Refund_DetailsResponseDTO show_Refund_Details(String refundid, String Authorization,
            String PayPalAuthAssertion) {
        
    }
    */
}
