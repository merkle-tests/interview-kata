** There is 3 repositories services: 

## CUSTOMER REPOSITORY
Given the following http request http://localhost:8080/customer/1 returns the following customer information in json format
```json
{
    "firstName":"Raquel",
    "middleName":"",
    "lastName":"",
    "gener":"Male",
    "birthDay":"12th December 1980",
    "age":"32",
    "address":"",
    "contactNumber":"",
    "contactEmail":""
}
```
You will have a customer repository JAR. This is what the repository will return. All fields will be String
```json
NAME
GENDER
BIRTHDAY
ADDRESS
    STREET NAME
    STREET NUMBER
    CITY
    POST CODE
    COUNTRY
EMAIL
TELEPHONE NUMBER
```

Rules
Name:
if it has two words, those should be firstName and lastName
if it has three word, firstName , middleName and lastName
If it has mora than 3 words, 1 -> firstName, 2 -> middleName, rest lastName

Gender:
M -> male
F -> female
X -> unspecified

Birthday:
It will return an String with the full date (yyyy/mm/dd), you should parse it.

Address:
You should concatenate all the fields to a String variable, like this example:
EXAMPLE MISSING

EMAIL:
no rules for email

TELEPHONE NUMBER:
you should return the international number format, using the following country list.
EXAMPLE COUNTRY LIST



 
## ProductRepository, returns a list of products with:

    

CustomerProductRepository
