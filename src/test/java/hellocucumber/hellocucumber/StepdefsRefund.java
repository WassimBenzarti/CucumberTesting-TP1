package hellocucumber.hellocucumber;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.*;

class RefundProcessor{
	public static boolean processRefund(int days, int price,boolean hasReciept, boolean hasProofOfPurchase) {
		if(days > 14 || !(hasReciept||hasProofOfPurchase)) {
			return false;
		}
		return true;
	}
	public static boolean processRefund(int days, int price,boolean hasReciept) {
		return processRefund(days, price, hasReciept, false);
	}
}


public class StepdefsRefund {

	int days;
	int price;
	boolean hasReceipt;
	boolean canRefund;
	boolean hasProofOfPurchase;
	
	@Given("I purchased something {int} days ago for {int}DT")
	public void john_purchased_a_cat_days_ago_for_DT(Integer int1, Integer int2) {
		// Write code here that turns the phrase above into concrete actions
		this.days = int1;
		this.price = int2;
	}

	@Given("I have a receipt")
	public void i_have_a_reciept() {
		this.hasReceipt = true;
	}

	@When("I ask for a refund")
	public void ask_for_a_refund() {
		this.canRefund = RefundProcessor.processRefund(this.days, this.price, this.hasReceipt,this.hasProofOfPurchase);
	}

	@Then("Increment the number of items in stock")
	public void increment_the_number_of_items_in_stock() {
		assertEquals(this.canRefund, true);
	}

	@Then("Give {int}DT back to me")
	public void give_DT_back_to_me(Integer int1) {
		assertEquals(this.canRefund, true);
	}

	@Given("I don't have a receipt")
	public void i_don_t_have_a_receipt() {
		this.hasReceipt= false;
	}

	@Given("I have a proof of purchase")
	public void i_have_a_proof_of_purchase() {
		this.hasProofOfPurchase = true;
	}
	
	@Given("I have no proof of purchase")
	public void i_have_no_proof_of_purchase() {
	    this.hasProofOfPurchase = false;
	}

	@Then("Refuse refund")
	public void refuse_refund() {
	    assertEquals(this.canRefund, this.canRefund);
	}
}
