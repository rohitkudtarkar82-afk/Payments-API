package Payments.Group.Payments.Controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;

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
import Payments.Group.Payments.DTO.Reauthorize_PaymentRequestDTO;
import Payments.Group.Payments.DTO.Reauthorize_PaymentResponseDTO;
import Payments.Group.Payments.DTO.Refund_Captured_PaymentRequestDTO;
import Payments.Group.Payments.DTO.Refund_Captured_PaymentResponseDTO;
import Payments.Group.Payments.DTO.Show_Captured_PaymentResponseDTO;
import Payments.Group.Payments.DTO.Show_Details_PaymentResponseDTO;
import Payments.Group.Payments.DTO.Show_Refund_DetailsResponseDTO;
import Payments.Group.Payments.Service.PaymentsService;

@RestController
@RequestMapping("/v2/payments")

public class PaymentController {

        @Autowired
        private PaymentsService paymentsService;

        @PostMapping("/authorizations/capture")
        public ResponseEntity<Capture_PaymentResponseDTO> capture_Payment(@RequestParam String authorizationid,
                        @RequestParam String PayPalRequestId, @RequestParam String Prefer,
                        @RequestParam String Authorization, @RequestParam String PayPalAuthAssertio,
                        @RequestBody Capture_PaymentRequestDTO capture_PaymentRequestDTO) {

                Capture_PaymentResponseDTO response = paymentsService.capture_Payment(authorizationid, PayPalRequestId,
                                Prefer, Authorization, PayPalAuthAssertio, capture_PaymentRequestDTO);

                return new ResponseEntity<>(response, HttpStatus.OK);
        }

        @PostMapping("/authorizations/reauthorize")
        public ResponseEntity<Reauthorize_PaymentResponseDTO> reauthorize_Payment(@RequestParam String authorizationid,
                        @RequestParam String PayPalRequestId, @RequestParam String Prefer,
                        @RequestParam String Authorization, @RequestParam String PayPalAuthAssertio,
                        @RequestBody Reauthorize_PaymentRequestDTO reauthorize_PaymentRequestDTO) {

                Reauthorize_PaymentResponseDTO response = paymentsService.reauthorize_Payment(authorizationid,
                                PayPalRequestId, Prefer, Authorization, PayPalAuthAssertio,
                                reauthorize_PaymentRequestDTO);

                return new ResponseEntity<>(response, HttpStatus.OK);

        }

        @PostMapping("/authorizations/void")
        public ResponseEntity<Authorized_PaymentResponseDTO> authorized_Payment(@RequestParam String authorizationid,
                        @RequestParam String PayPalRequestId, @RequestParam String Prefer,
                        @RequestParam String Authorization, @RequestParam String PayPalAuthAssertion,
                        @RequestBody Authorized_PaymentRequestDTO authorized_PaymentRequestDTO) {

                Authorized_PaymentResponseDTO response = paymentsService.authorized_Payment(authorizationid,
                                PayPalRequestId, Prefer, Authorization, PayPalAuthAssertion,
                                authorized_PaymentRequestDTO);

                return new ResponseEntity<>(response, HttpStatus.OK);

        }

        @PostMapping("/find-eligible-methods")
        public ResponseEntity<List_Eligible_PaymentResponseDTO> list_Eligible_Payment(
                        @RequestParam String Authorization, @RequestParam String PayPalAuthAssertion,
                        @RequestParam String UserAgent, @RequestParam String PayPalClientMetadataId,
                        @RequestBody List_Eligible_PaymentRequestDTO list_Eligible_PaymentRequestDTO) {

                List_Eligible_PaymentResponseDTO response = paymentsService.list_Eligible_Payment(Authorization,
                                PayPalAuthAssertion, UserAgent, PayPalClientMetadataId,
                                list_Eligible_PaymentRequestDTO);

                return new ResponseEntity<>(response, HttpStatus.OK);

        }

        @PostMapping("/captures/refund")
        public ResponseEntity<Refund_Captured_PaymentResponseDTO> refund_Captured_Payment(
                        @RequestParam String captureid, @RequestParam String PayPalRequestId,
                        @RequestParam String Prefer, @RequestParam String Authorization,
                        @RequestParam String PayPalAuthAssertion,
                        @RequestBody Refund_Captured_PaymentRequestDTO refund_Captured_PaymentRequestDTO) {

                Refund_Captured_PaymentResponseDTO response = paymentsService.refund_Captured_Payment(captureid,
                                PayPalRequestId, Prefer, Authorization, PayPalAuthAssertion,
                                refund_Captured_PaymentRequestDTO);

                return new ResponseEntity<>(response, HttpStatus.OK);

        }

        @GetMapping("/refunds")
        public ResponseEntity<Show_Refund_DetailsResponseDTO> show_Refund_Details(@RequestParam String refundid) {
                System.out.println("controller refundid: " + refundid);
                return new ResponseEntity<>(paymentsService.show_Refund_Details(refundid), HttpStatus.OK);
        }

        @GetMapping("/captures")
        public ResponseEntity<Show_Captured_PaymentResponseDTO> show_Captured_Payment(
                        @RequestParam String captureid) {

                System.out.println("controller captureid: " + captureid);

                return new ResponseEntity<>(
                                paymentsService.show_Captured_Payment(captureid),
                                HttpStatus.OK);
        }

        @GetMapping("/authorizations")
public ResponseEntity<Show_Details_PaymentResponseDTO> show_Details_Payment(
        @RequestParam String authorizationid) {

    System.out.println("controller authorizationid: " + authorizationid);

    return new ResponseEntity<>(
            paymentsService.show_Details_Payment(authorizationid),
            HttpStatus.OK);
}

}