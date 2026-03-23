package Payments.Group.Payments.Controller;



import java.util.List;
import java.util.UUID;

import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Payments.Group.Payments.DTO.Authorized_PaymentRequestDTO;
import Payments.Group.Payments.DTO.Authorized_PaymentResponseDTO;
import Payments.Group.Payments.DTO.Capture_PaymentRequestDTO;
import Payments.Group.Payments.DTO.Capture_PaymentResponseDTO;
import Payments.Group.Payments.DTO.List_Eligible_PaymentRequestDTO;
import Payments.Group.Payments.DTO.List_Eligible_PaymentResponseDTO;
import Payments.Group.Payments.DTO.Payment_InstructionRequestDTO;
import Payments.Group.Payments.DTO.Reauthorize_PaymentRequestDTO;
import Payments.Group.Payments.DTO.Reauthorize_PaymentResponseDTO;
import Payments.Group.Payments.DTO.Refund_Captured_PaymentRequestDTO;
import Payments.Group.Payments.DTO.Refund_Captured_PaymentResponseDTO;
import Payments.Group.Payments.Service.PaymentsService;

@RestController
//@RequestMapping("/v2/payments")
@RequestMapping("/v2/payments/authorizations")
//@RequestMapping("/v2/payments/captures")
public class PaymentController {

    @Autowired
    private PaymentsService paymentsService;

       @PostMapping("/capture")
    public ResponseEntity<Capture_PaymentResponseDTO> capture_Payment(@RequestParam String authorizationid, @RequestParam String PayPalRequestId, @RequestParam String Prefer, @RequestParam String Authorization, @RequestParam String PayPalAuthAssertio,
            @RequestBody Capture_PaymentRequestDTO capture_PaymentRequestDTO) {

        Capture_PaymentResponseDTO response =
                paymentsService.capture_Payment(authorizationid , PayPalRequestId, Prefer, Authorization, PayPalAuthAssertio, capture_PaymentRequestDTO);

        return new ResponseEntity<>(response, HttpStatus.OK);
    } 

    /*  @PostMapping("/reauthorize")
    public ResponseEntity<Reauthorize_PaymentResponseDTO> reauthorize_Payment(@RequestParam String authorizationid, @RequestParam String PayPalRequestId, @RequestParam String Prefer, @RequestParam String Authorization, @RequestParam String PayPalAuthAssertio,
            @RequestBody Reauthorize_PaymentRequestDTO reauthorize_PaymentRequestDTO) {

        Reauthorize_PaymentResponseDTO response =
                paymentsService.reauthorize_Payment(authorizationid , PayPalRequestId, Prefer, Authorization, PayPalAuthAssertio, reauthorize_PaymentRequestDTO);

        return new ResponseEntity<>(response, HttpStatus.OK);

            } */

         /*     @PostMapping("/void")
    public ResponseEntity<Authorized_PaymentResponseDTO> authorized_Payment(@RequestParam String authorizationid, @RequestParam String PayPalRequestId, @RequestParam String Prefer, @RequestParam String Authorization, @RequestParam String PayPalAuthAssertion,
            @RequestBody Authorized_PaymentRequestDTO authorized_PaymentRequestDTO) {

        Authorized_PaymentResponseDTO response =
                paymentsService.authorized_Payment(authorizationid , PayPalRequestId, Prefer, Authorization, PayPalAuthAssertion, authorized_PaymentRequestDTO);

        return new ResponseEntity<>(response, HttpStatus.OK);

            }*/

        /*   @PostMapping("/find-eligible-methods")
    public ResponseEntity<List_Eligible_PaymentResponseDTO> list_Eligible_Payment(@RequestParam String Authorization, @RequestParam String PayPalAuthAssertion, @RequestParam String UserAgent, @RequestParam String PayPalClientMetadataId,
            @RequestBody List_Eligible_PaymentRequestDTO list_Eligible_PaymentRequestDTO) {

        List_Eligible_PaymentResponseDTO response =
                paymentsService.list_Eligible_Payment( Authorization, PayPalAuthAssertion, UserAgent, PayPalClientMetadataId, list_Eligible_PaymentRequestDTO);

        return new ResponseEntity<>(response, HttpStatus.OK);

            } */

        /*   @PostMapping("/refund")
    public ResponseEntity<Refund_Captured_PaymentResponseDTO> refund_Captured_Payment(@RequestParam String captureid, @RequestParam String PayPalRequestId, @RequestParam String Prefer, @RequestParam String Authorization, @RequestParam String PayPalAuthAssertion,
            @RequestBody Refund_Captured_PaymentRequestDTO refund_Captured_PaymentRequestDTO) {

        Refund_Captured_PaymentResponseDTO response =
                paymentsService.refund_Captured_Payment(captureid, PayPalRequestId, Prefer, Authorization, PayPalAuthAssertion, refund_Captured_PaymentRequestDTO);

        return new ResponseEntity<>(response, HttpStatus.OK);

            }*/
        
}