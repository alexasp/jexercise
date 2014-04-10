package inheritance;

import inheritance.BSU;
import junit.framework.TestCase;
import no.hal.jex.runtime.JExercise;

@JExercise(description = "Tests inheritance.BSU")
@SuppressWarnings("all")
public class BSUTest extends TestCase {
  private BSU bsu;
  
  private BSU _init_bsu() {
    BSU _bSU = new BSU(0.05, 25000.0);
    return _bSU;
  }
  
  @Override
  protected void setUp() {
    bsu = _init_bsu();
    
  }
  
  @JExercise(tests = "BSU(double,double);void deposit(double);void endYearUpdate()", description = "Tests \n\t\tthe following sequence:\n\t\t<ul>\n\t\t<li>bsu.deposit(10000.0)</li>\n\t\t<li>bsu.deposit(-10000.0)</li>\n\t\t<li>bsu.deposit(20000.0)</li>\n\t\t<li>bsu.endYearUpdate(), bsu.deposit(20000.0)</li>\n\t\t</ul>\n")
  public void testDeposit() {
    _transition_exprAction__deposit_transitions0_actions0(bsu);
    _test__deposit_transitions0_effect_state(bsu);
    try {
      _transition_exprAction__deposit_transitions1_actions0(bsu);
      fail("IllegalArgumentException should be thrown after bsu.deposit(-10000.0)");
    } catch (Exception e) {
      assertTrue("IllegalArgumentException should be thrown after bsu.deposit(-10000.0)", e instanceof IllegalArgumentException);
    }
    _test__deposit_transitions2_effect_state(bsu);
    try {
      _transition_exprAction__deposit_transitions3_actions0(bsu);
      fail("IllegalStateException should be thrown after bsu.deposit(20000.0)");
    } catch (Exception e_1) {
      assertTrue("IllegalStateException should be thrown after bsu.deposit(20000.0)", e_1 instanceof IllegalStateException);
    }
    _test__deposit_transitions4_effect_state(bsu);
    _transition_exprAction__deposit_transitions5_actions0(bsu);
    _transition_exprAction__deposit_transitions5_actions1(bsu);
    _test__deposit_transitions5_effect_state(bsu);
    
  }
  
  @JExercise(tests = "BSU(double,double);void deposit(double);void withdraw(double);void endYearUpdate()", description = "Tests \n\t\tthe following sequence:\n\t\t<ul>\n\t\t<li>bsu.deposit(20000.0), bsu.withdraw(5000.0)</li>\n\t\t<li>bsu.withdraw(-10000.0)</li>\n\t\t<li>bsu.withdraw(20000.0)</li>\n\t\t<li>bsu.endYearUpdate(), bsu.withdraw(10000.0)</li>\n\t\t</ul>\n")
  public void testWithdraw() {
    _transition_exprAction__withdraw_transitions0_actions0(bsu);
    _transition_exprAction__withdraw_transitions0_actions1(bsu);
    _test__withdraw_transitions0_effect_state(bsu);
    try {
      _transition_exprAction__withdraw_transitions1_actions0(bsu);
      fail("IllegalArgumentException should be thrown after bsu.withdraw(-10000.0)");
    } catch (Exception e) {
      assertTrue("IllegalArgumentException should be thrown after bsu.withdraw(-10000.0)", e instanceof IllegalArgumentException);
    }
    _test__withdraw_transitions2_effect_state(bsu);
    try {
      _transition_exprAction__withdraw_transitions3_actions0(bsu);
      fail("IllegalStateException should be thrown after bsu.withdraw(20000.0)");
    } catch (Exception e_1) {
      assertTrue("IllegalStateException should be thrown after bsu.withdraw(20000.0)", e_1 instanceof IllegalStateException);
    }
    _test__withdraw_transitions4_effect_state(bsu);
    try {
      _transition_exprAction__withdraw_transitions5_actions0(bsu);
      _transition_exprAction__withdraw_transitions5_actions1(bsu);
      fail("IllegalStateException should be thrown after bsu.endYearUpdate(), bsu.withdraw(10000.0)");
    } catch (Exception e_2) {
      assertTrue("IllegalStateException should be thrown after bsu.endYearUpdate(), bsu.withdraw(10000.0)", e_2 instanceof IllegalStateException);
    }
    _test__withdraw_transitions6_effect_state(bsu);
    
  }
  
  @JExercise(tests = "BSU(double,double);void deposit(double);void endYearUpdate()", description = "Tests \n\t\tthe following sequence:\n\t\t<ul>\n\t\t<li>bsu.deposit(20000.0)</li>\n\t\t<li>bsu.endYearUpdate, bsu.deposit(10000.0)</li>\n\t\t<li>bsu.endYearUpdate</li>\n\t\t</ul>\n")
  public void testGetTaxDeduction() {
    _transition_exprAction__getTaxDeduction_transitions0_actions0(bsu);
    _test__getTaxDeduction_transitions0_effect_state(bsu);
    _transition_exprAction__getTaxDeduction_transitions1_actions0(bsu);
    _transition_exprAction__getTaxDeduction_transitions1_actions1(bsu);
    _test__getTaxDeduction_transitions1_effect_state(bsu);
    _transition_exprAction__getTaxDeduction_transitions2_actions0(bsu);
    _test__getTaxDeduction_transitions2_effect_state(bsu);
    
  }
  
  private void _transition_exprAction__deposit_transitions0_actions0(final BSU it) {
    try {
      
      this.bsu.deposit(10000.0);
      } catch (junit.framework.AssertionFailedError error) {
      fail("bsu.deposit(10000.0) failed: " + error.getMessage());
    }
    
  }
  
  private void _test__deposit_transitions0_effect_state(final BSU it) {
    _test__deposit_transitions0_effect_state_objectTests0_test(bsu);
    
  }
  
  private void _test__deposit_transitions0_effect_state_objectTests0_test(final BSU it) {
    
    assertNotNull("bsu.balance ?= failed after bsu.deposit(10000.0)", this.bsu.balance);
    try {
      
      /* 10000.0 */
      } catch (junit.framework.AssertionFailedError error) {
      fail("10000.0 failed after bsu.deposit(10000.0): " + error.getMessage());
    }
    
  }
  
  private void _transition_exprAction__deposit_transitions1_actions0(final BSU it) {
    try {
      
      double _minus = (-10000.0);
      this.bsu.deposit(_minus);
      } catch (junit.framework.AssertionFailedError error) {
      fail("bsu.deposit(-10000.0) failed: " + error.getMessage());
    }
    
  }
  
  private void _test__deposit_transitions2_effect_state(final BSU it) {
    _test__deposit_transitions2_effect_state_objectTests0_test(bsu);
    
  }
  
  private void _test__deposit_transitions2_effect_state_objectTests0_test(final BSU it) {
    
    assertNotNull("bsu.balance ?= failed", this.bsu.balance);
    try {
      
      /* 10000.0 */
      } catch (junit.framework.AssertionFailedError error) {
      fail("10000.0 failed: " + error.getMessage());
    }
    
  }
  
  private void _transition_exprAction__deposit_transitions3_actions0(final BSU it) {
    try {
      
      this.bsu.deposit(20000.0);
      } catch (junit.framework.AssertionFailedError error) {
      fail("bsu.deposit(20000.0) failed: " + error.getMessage());
    }
    
  }
  
  private void _test__deposit_transitions4_effect_state(final BSU it) {
    _test__deposit_transitions4_effect_state_objectTests0_test(bsu);
    
  }
  
  private void _test__deposit_transitions4_effect_state_objectTests0_test(final BSU it) {
    
    assertNotNull("bsu.balance ?= failed", this.bsu.balance);
    try {
      
      /* 10000.0 */
      } catch (junit.framework.AssertionFailedError error) {
      fail("10000.0 failed: " + error.getMessage());
    }
    
  }
  
  private void _transition_exprAction__deposit_transitions5_actions0(final BSU it) {
    try {
      
      this.bsu.endYearUpdate();
      } catch (junit.framework.AssertionFailedError error) {
      fail("bsu.endYearUpdate() failed: " + error.getMessage());
    }
    
  }
  
  private void _transition_exprAction__deposit_transitions5_actions1(final BSU it) {
    try {
      
      this.bsu.deposit(20000.0);
      } catch (junit.framework.AssertionFailedError error) {
      fail("bsu.deposit(20000.0) failed: " + error.getMessage());
    }
    
  }
  
  private void _test__deposit_transitions5_effect_state(final BSU it) {
    _test__deposit_transitions5_effect_state_objectTests0_test(bsu);
    
  }
  
  private void _test__deposit_transitions5_effect_state_objectTests0_test(final BSU it) {
    
    assertNotNull("bsu.balance ?= failed after bsu.endYearUpdate() ,bsu.deposit(20000.0)", this.bsu.balance);
    
    double _plus = (1 + 0.05);
    double _multiply = (10000.0 * _plus);
    double _plus_1 = (_multiply + 20000.0);
    assertNotNull("10000.0 * (1 + 0.05) + 20000.0 failed after bsu.endYearUpdate() ,bsu.deposit(20000.0)", _plus_1);
    
  }
  
  private void _transition_exprAction__withdraw_transitions0_actions0(final BSU it) {
    try {
      
      this.bsu.deposit(20000.0);
      } catch (junit.framework.AssertionFailedError error) {
      fail("bsu.deposit(20000.0) failed: " + error.getMessage());
    }
    
  }
  
  private void _transition_exprAction__withdraw_transitions0_actions1(final BSU it) {
    try {
      
      this.bsu.withdraw(5000.0);
      } catch (junit.framework.AssertionFailedError error) {
      fail("bsu.withdraw(5000.0) failed: " + error.getMessage());
    }
    
  }
  
  private void _test__withdraw_transitions0_effect_state(final BSU it) {
    _test__withdraw_transitions0_effect_state_objectTests0_test(bsu);
    
  }
  
  private void _test__withdraw_transitions0_effect_state_objectTests0_test(final BSU it) {
    
    assertNotNull("bsu.balance ?= failed after bsu.deposit(20000.0) ,bsu.withdraw(5000.0)", this.bsu.balance);
    try {
      
      /* 15000.0 */
      } catch (junit.framework.AssertionFailedError error) {
      fail("15000.0 failed after bsu.deposit(20000.0) ,bsu.withdraw(5000.0): " + error.getMessage());
    }
    
  }
  
  private void _transition_exprAction__withdraw_transitions1_actions0(final BSU it) {
    try {
      
      double _minus = (-10000.0);
      this.bsu.withdraw(_minus);
      } catch (junit.framework.AssertionFailedError error) {
      fail("bsu.withdraw(-10000.0) failed: " + error.getMessage());
    }
    
  }
  
  private void _test__withdraw_transitions2_effect_state(final BSU it) {
    _test__withdraw_transitions2_effect_state_objectTests0_test(bsu);
    
  }
  
  private void _test__withdraw_transitions2_effect_state_objectTests0_test(final BSU it) {
    
    assertNotNull("bsu.balance ?= failed", this.bsu.balance);
    try {
      
      /* 15000.0 */
      } catch (junit.framework.AssertionFailedError error) {
      fail("15000.0 failed: " + error.getMessage());
    }
    
  }
  
  private void _transition_exprAction__withdraw_transitions3_actions0(final BSU it) {
    try {
      
      this.bsu.withdraw(20000.0);
      } catch (junit.framework.AssertionFailedError error) {
      fail("bsu.withdraw(20000.0) failed: " + error.getMessage());
    }
    
  }
  
  private void _test__withdraw_transitions4_effect_state(final BSU it) {
    _test__withdraw_transitions4_effect_state_objectTests0_test(bsu);
    
  }
  
  private void _test__withdraw_transitions4_effect_state_objectTests0_test(final BSU it) {
    
    assertNotNull("bsu.balance ?= failed", this.bsu.balance);
    try {
      
      /* 15000.0 */
      } catch (junit.framework.AssertionFailedError error) {
      fail("15000.0 failed: " + error.getMessage());
    }
    
  }
  
  private void _transition_exprAction__withdraw_transitions5_actions0(final BSU it) {
    try {
      
      this.bsu.endYearUpdate();
      } catch (junit.framework.AssertionFailedError error) {
      fail("bsu.endYearUpdate() failed: " + error.getMessage());
    }
    
  }
  
  private void _transition_exprAction__withdraw_transitions5_actions1(final BSU it) {
    try {
      
      this.bsu.withdraw(10000.0);
      } catch (junit.framework.AssertionFailedError error) {
      fail("bsu.withdraw(10000.0) failed: " + error.getMessage());
    }
    
  }
  
  private void _test__withdraw_transitions6_effect_state(final BSU it) {
    _test__withdraw_transitions6_effect_state_objectTests0_test(bsu);
    
  }
  
  private void _test__withdraw_transitions6_effect_state_objectTests0_test(final BSU it) {
    
    assertNotNull("bsu.balance ?= failed", this.bsu.balance);
    
    double _plus = (1 + 0.05);
    double _multiply = (15000.0 * _plus);
    assertNotNull("15000.0 * (1 + 0.05) failed", _multiply);
    
  }
  
  private void _transition_exprAction__getTaxDeduction_transitions0_actions0(final BSU it) {
    try {
      
      this.bsu.deposit(20000.0);
      } catch (junit.framework.AssertionFailedError error) {
      fail("bsu.deposit(20000.0) failed: " + error.getMessage());
    }
    
  }
  
  private void _test__getTaxDeduction_transitions0_effect_state(final BSU it) {
    _test__getTaxDeduction_transitions0_effect_state_objectTests0_test(bsu);
    
  }
  
  private void _test__getTaxDeduction_transitions0_effect_state_objectTests0_test(final BSU it) {
    
    double _taxDeduction = this.bsu.getTaxDeduction();
    assertNotNull("bsu.taxDeduction ?= failed after bsu.deposit(20000.0)", _taxDeduction);
    
    double _multiply = (20000.0 * 0.20);
    assertNotNull("20000.0 * 0.20 failed after bsu.deposit(20000.0)", _multiply);
    
  }
  
  private void _transition_exprAction__getTaxDeduction_transitions1_actions0(final BSU it) {
    try {
      
      this.bsu.endYearUpdate();
      } catch (junit.framework.AssertionFailedError error) {
      fail("bsu.endYearUpdate failed: " + error.getMessage());
    }
    
  }
  
  private void _transition_exprAction__getTaxDeduction_transitions1_actions1(final BSU it) {
    try {
      
      this.bsu.deposit(10000.0);
      } catch (junit.framework.AssertionFailedError error) {
      fail("bsu.deposit(10000.0) failed: " + error.getMessage());
    }
    
  }
  
  private void _test__getTaxDeduction_transitions1_effect_state(final BSU it) {
    _test__getTaxDeduction_transitions1_effect_state_objectTests0_test(bsu);
    
  }
  
  private void _test__getTaxDeduction_transitions1_effect_state_objectTests0_test(final BSU it) {
    
    double _taxDeduction = this.bsu.getTaxDeduction();
    assertNotNull("bsu.taxDeduction ?= failed after bsu.endYearUpdate ,bsu.deposit(10000.0)", _taxDeduction);
    
    double _multiply = (10000.0 * 0.20);
    assertNotNull("10000.0 * 0.20 failed after bsu.endYearUpdate ,bsu.deposit(10000.0)", _multiply);
    
  }
  
  private void _transition_exprAction__getTaxDeduction_transitions2_actions0(final BSU it) {
    try {
      
      this.bsu.endYearUpdate();
      } catch (junit.framework.AssertionFailedError error) {
      fail("bsu.endYearUpdate failed: " + error.getMessage());
    }
    
  }
  
  private void _test__getTaxDeduction_transitions2_effect_state(final BSU it) {
    _test__getTaxDeduction_transitions2_effect_state_objectTests0_test(bsu);
    
  }
  
  private void _test__getTaxDeduction_transitions2_effect_state_objectTests0_test(final BSU it) {
    
    double _taxDeduction = this.bsu.getTaxDeduction();
    assertNotNull("bsu.taxDeduction ?= failed after bsu.endYearUpdate", _taxDeduction);
    try {
      
      /* 0.0 */
      } catch (junit.framework.AssertionFailedError error) {
      fail("0.0 failed after bsu.endYearUpdate: " + error.getMessage());
    }
    
  }
  
  public static void main(final String[] args) {
    no.hal.jex.standalone.JexStandalone.main(BSUTest.class);
  }
}
