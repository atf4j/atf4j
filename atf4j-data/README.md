# Automated Test Framework for Java

## Automation Test Framework for Java - Data

Java Automation Test Framework for Data Driven Testing.

## Usage

### Find all the message files under the resources (src/main/resources) folder messages.

    public final class MessageWalker extends AbstractFolderWalker {
        private MessageWalker() {
            super("/messages");
        }
    }

    @Test
    public void testAbstractWalker() {
        new MessageWalker().walk();
    }


### Find data that fits a specific criteria

    @Test
    public void testLogin() {
    	// Given an authorised user 
	Credentials.for(Credentials.AUTHORISED);
    }

    @Test
    public void test() {
	Customer customer = DataManager.for("@CREDIT-CUSTOMER");
	orderPage.enterCustomerName(customer.name);
    }
