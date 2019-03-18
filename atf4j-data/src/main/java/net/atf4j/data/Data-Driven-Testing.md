# java-coaching - Automation
| [Automation](src/main/java/automation "Automated Testing with Java") | [Java Coaching](src/main/java/coaching "Coaching Java Idioms") | [Java Patterns](src/main/java/patterns "Design Patterns in Java") |

## Data Driven Testing

### Expected Data handling using tags

	ExpectedData.get("@Characteristic");


### Credentials with Characteristic tags

#### Simple

	final Actor actor = credentials.tagged("@AUTHORISED");

#### Platform management by System property

	-Dplatform={local|dev|sit|pp}

	final Actor actor = credentials.tagged("@AUTHORISED");

#### Customised Platform management 

	final Actor actor = credentials.on(platform).tagged("@F");

#### Data-Source(s)

#### Default folder location when no platform is specified.

	{resource-root}/data/Credentials.csv

#### Platform is used sub-folder under the default folder.
	
	{resource-root}/data/local/Credentials.csv
	{resource-root}/data/dev/Credentials.csv
	{resource-root}/data/sit/Credentials.csv
	{resource-root}/data/pp/Credentials.csv

#### Example Credentials.csv

	# tags, username, password, email
	@ADMIN,admin,password,admin@example.com
	@AUTHORISED,alice,password,alice@example.com
	@AUTHORISED,bob,password,bob@example.com
	@UNAUTHORISED,trudy,password,trudy@example.com

