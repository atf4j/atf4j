def pool = ['a'..'z',0..9].flatten()

Random rand = new Random(System.currentTimeMillis())
def randomChars = (0..3).collect { pool[rand.nextInt(pool.size())] }
def endOfWord = randomChars.join()
newUserName = "userName" + endOfWord
newUserEmail = newUserName + "@example.com"
def testCase = testRunner.testCase

	def tester()
	{
		log.info( "randomForename="+randomForename() )
		log.info( "randomMiddlename="+randomMiddlename() )
		log.info( "randomSurname="+randomSurname() )
		log.info( "1.createRandomName="+createRandomName() )
		log.info( "2.createRandomName="+createRandomName() )
		log.info( "3.createRandomName="+createRandomName() )
		log.info( "4.createRandomName="+createRandomName() )
		log.info( "5.createRandomName="+createRandomName() )
	}

nameFactory = new NameFactory( log, context, testRunner) 
context.setProperty( "nameFactory=", nameFactory )
log.info "Library Context="+context
// nameFactory.tester()

	def tester()
	{
		log.info "Master Card Number = "+getValidMasterCardNumber()
		log.info "Visa Number = "+getValidVisaDebitNumber()
	}	
}

cardFactory = new CardFactory( log, context, testRunner) 
context.setProperty( "cardFactory=", cardFactory )
log.info "Library Context="+context
// cardFactory.tester()
