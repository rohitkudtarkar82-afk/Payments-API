package Payments.Group.Payments.Service;

import java.util.List;

import Payments.Group.Payments.DTO.Authorized_PaymentRequestDTO;
import Payments.Group.Payments.DTO.Authorized_PaymentResponseDTO;
import Payments.Group.Payments.DTO.Capture_PaymentRequestDTO;
import Payments.Group.Payments.DTO.Capture_PaymentResponseDTO;
import Payments.Group.Payments.DTO.LinksResponseDTO;
import Payments.Group.Payments.DTO.List_Eligible_PaymentRequestDTO;
import Payments.Group.Payments.DTO.List_Eligible_PaymentResponseDTO;
import Payments.Group.Payments.DTO.Payment_InstructionRequestDTO;
import Payments.Group.Payments.DTO.Reauthorize_PaymentRequestDTO;
import Payments.Group.Payments.DTO.Reauthorize_PaymentResponseDTO;
import Payments.Group.Payments.DTO.Refund_Captured_PaymentRequestDTO;
import Payments.Group.Payments.DTO.Refund_Captured_PaymentResponseDTO;
import Payments.Group.Payments.DTO.Show_Captured_PaymentResponseDTO;
import Payments.Group.Payments.DTO.Show_Details_PaymentResponseDTO;
import Payments.Group.Payments.DTO.Show_Refund_DetailsResponseDTO;


public interface PaymentsService {

    // 1. GET: Show details for authorized payment
     Show_Details_PaymentResponseDTO show_Details_Payment(

            String authorizationid,

            String Authorization,

            String PayPalAuthAssertion
        ); 

    // 2. POST: Capture authorized payment
      Capture_PaymentResponseDTO capture_Payment(

            String authorizationid,

            String PayPalRequestId,

            String Prefer,

            String Authorization,

            String PayPalAuthAssertion,

            Capture_PaymentRequestDTO capture_PaymentRequestDTO
            
    );

    // 3. POST: Reauthorize authorized payment
     /*    Reauthorize_PaymentResponseDTO reauthorize_Payment(
            String authorizationid,
            String PayPalRequestId,
            String Prefer,
            String Authorization,
            String PayPalAuthAssertion,
            Reauthorize_PaymentRequestDTO reauthorize_PaymentRequestDTO
    );*/



     // 4. POST: Void authorized payment
      /*     Authorized_PaymentResponseDTO authorized_Payment(

            String authorization_id,

            String Authorization,

            String PayPalAuthAssertion,

            String PayPalRequestId,

            String Prefer,

            Authorized_PaymentRequestDTO authorized_PaymentRequestDTO

    );*/

    // 5. GET: Show captured payment details
    /* Show_Captured_PaymentResponseDTO show_Captured_Payment(

            String captureid,

            String Authorization
        );

    // 6. POST: Refund captured payment
            Refund_Captured_PaymentResponseDTO refund_Captured_Payment(

            String captureid,

            String PayPalRequestId,

            String Prefer,

            String Authorization,

            String PayPalAuthAssertion,

            Refund_Captured_PaymentRequestDTO refund_Captured_PaymentRequestDTO
            
        );

    // 7. POST: Find a list of eligible payment methods
    List_Eligible_PaymentResponseDTO list_Eligible_Payment(

            String Authorization,

            String PayPalAuthAssertion,

            String UserAgent,

            String PayPalClientMetadataId,

            List_Eligible_PaymentRequestDTO list_Eligible_PaymentRequestDTO
        );

    // 8. GET: Show refund details
        Show_Refund_DetailsResponseDTO show_Refund_Details(

            String refundid,

            String Authorization,

            String PayPalAuthAssertion
        );*/

        List<LinksResponseDTO> getAllLinks();

        Authorized_PaymentResponseDTO authorized_Payment(String authorization_id, String Authorization,
                String PayPalAuthAssertion, String PayPalRequestId, String Prefer);

}
