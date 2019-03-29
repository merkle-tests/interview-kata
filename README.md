# Background

Our client, SkiTV, is a company that provides broadband entertainment services to its subscribers.
They have hired us to create new JSON REST APIs for their frontend on top of the infrastructure they already have.

## Current available infrastructure
Our client already has a repository infrastructure that they have asked us to reuse, it consists of the following repositories:

_(TODO: Review the repositories information)_

CUSTOMER API:
There is a Customer Repository JAR. The repository will return a Customer object with the
following attributes:
     String accountNumber, String name, String gender, String birthday, String email, String phoneNumber, Address address (containing
        String addressLine1, String addressLine2, String city, String postCode, String country)
and a CustomerRepository object with the following attributes:
    String customerId, String productId, String effectiveFrom, String effectiveTo

PRODUCT API:
The Product Repository will provide us with the Product object with the following attributes:
     String id, String name, String price;

# New Requirements

## 1) Customer information REST API

Our client has asked us to provide a REST API that will return information about their subscribers.

They are expecting the following http request `http://localhost:8080/customer/1` to return the following
customer information in json format:

```json
{
    "firstName":"Miguel",
    "middleName":"",
    "lastName":"Ferrandis",
    "gender":"male",
    "birthday":"12th December 1980",
    "age":"32",
    "address":"C/Bergara 22 P3 P6 08085-Barcelona (Spain)",
    "contactNumber":"+34 666 111 333",
    "contactEmail":"miguel@gmail.com"
}
```

However, as you might have realised, the repository is not returning the customer data in this format. 
We have already agreed with them the following rules:

* **Name:**
    * if it is composed by two words, those should be firstName and lastName
    * if it is composed by three words, they represent firstName, middleName and lastName
    * if it is composed by more than three words, 1 -> firstName, 2 -> middleName, rest -> lastName

* **Gender:**
    * M -> male
    * F -> female
    * X -> unspecified

* **Birthday:**
The repository will return an String with the date with format: `yyyy/mm/dd`.
The REST API should return the date with the format of the example (`12th December 1980`).

* **Address:**
You should concatenate all the fields to a String variable, like this example:
C/Bergara 22 P3 P6 08085-Barcelona (Spain)

EMAIL:
no rules for email

TELEPHONE NUMBER:
you should return the international number format, using the following country list.
- Spain: +34
- UK:    +44
- IRL:   +353

Possible updates/changes
* make a request for an unknown customer
* do updates to the customer
 
## 2) Customer product information REST API

The product repository will return a list of all the products for all the customers.

Then you should pick up only the products of your customer and return them in the following format:

WE can also have the repo with two functions, getAll, and getAllByPartyId. Then make the customer repo to return partyId not for all the customers, so the ones with partyId will be able to use the filter function, while the others will need to pick the correct products using accountNumber


```json
id
name
status
startingDate
```
    

## 3) Customer invoice information REST API

We want the monthly invoce for a customer. You will need to return the active products for the specified month, their prices and a total.



```json
{
	"customer": {
		"firstName": "Raquel",
		"middleName": "",
		"lastName": "",
		"address": "",
		"contactNumber": "",
		"contactEmail": ""
	},
	"invoiceDate:": "",
	"products": [{
			"name": "Product A",
			"price": 0.00
		},
		{
			"name": "product B",
			"price": 0.00
		}
	],
	"subtotal": 0.00,
	"total": 0.00
}
```

- summary of the kata for the candidate
- document for the interviewer (common questions for second interview or updates to the kata for pairing process)
- create JARS and DATA for them
- do the kata in your free time 
- some test already done to validate kata
