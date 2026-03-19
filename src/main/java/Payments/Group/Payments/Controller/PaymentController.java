package Payments.Group.Payments.Controller;



import java.util.List;
import java.util.UUID;

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
import Payments.Group.Payments.DTO.Payment_InstructionRequestDTO;
import Payments.Group.Payments.DTO.Reauthorize_PaymentRequestDTO;
import Payments.Group.Payments.DTO.Reauthorize_PaymentResponseDTO;
import Payments.Group.Payments.Service.PaymentsService;

@RestController
@RequestMapping("/v2/payments/authorizations")
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

            }*/

         /*    @PostMapping("/void")
    public ResponseEntity<Authorized_PaymentResponseDTO> authorized_Payment(@RequestParam String authorizationid, @RequestParam String PayPalRequestId, @RequestParam String Prefer, @RequestParam String Authorization, @RequestParam String PayPalAuthAssertio,
            @RequestBody Authorized_PaymentRequestDTO authorized_PaymentRequestDTO) {

        Authorized_PaymentResponseDTO response =
                paymentsService.authorized_Payment(authorizationid , PayPalRequestId, Prefer, Authorization, PayPalAuthAssertio, authorized_PaymentRequestDTO);

        return new ResponseEntity<>(response, HttpStatus.OK);

            }*/
}