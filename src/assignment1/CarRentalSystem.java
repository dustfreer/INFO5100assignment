package assignment1;
/*
 * A Car Rental System;
 * Pseudo code;
 * Designed by Kai Tian;
 */

Object of System{
	Rentalservice;
	Renter;
	Client;
}
------------------------------------------------------------------------------------

Object of Rentalservice{
	Car.licensePlate; 
	Car.model;
	Car.colour;
	Car.state; // check car is avaliable(int): 0 means available, 1 means rented, 2 means repair
	Car.priceForRent;
	Car.nameOfClient;
	
}

Function of Rentalservice{
	registerAccount;
	createInformation;
	rentCar;
	CheckCar; //when cars are returned back, check the state of cars
	returnCar;
	CreditCardService;
	
}
------------------------------------------------------------------------------------

Object of Renter{
	Renter.username;
	Renter.password;
	Renter.email;
}

Function of Renter{
	addCarInformation;
	confirmOrder;
	confirmReturnRequested;
}
------------------------------------------------------------------------------------

Ojbect of Client{
	Client.username;
	Client.password;
	Client.license;
	Client.phoneNumber;
	Client.email;
	
}

Function of Client{
	login;
	rentCar;
	reviewOrder;
	cancleOrder;
	returnCar;
	contactRentalservice;
	PayOrder;
}
------------------------------------------------------------------------------------

Class RentalSystem{
Behaviour: initiate(List, renterOrClient){
	if (renterOrClient == 0) {// 0 means renter;
		set {Renter.username;
			Renter.password;
			Renter.email;}
		to database;
	}else {
		set {Client.username;
			Client.password;
			Client.license;
			Client.phoneNumber;
			Client.email;}
		to database;
		
	}
}

Behaviour: createInformation(List<Car> car){
	set {Car.licensePlate;
		Car.model;
		Car.colour;
		Car.state; // check car is avaliable(int): 0 means available, 1 means rented, 2 means repair
		Car.priceForRent;
		Car.nameOfClient;}
	to database;
	return "Information of a new car creates successfully";
}

Behaviour: searchCar(parameters){
	inquire Information of a car from database;
	return List<Car> car;
}

Behaviour: rentCar(client.license, car.licensePlate){
	searchCar(car.licensePlate);
	//get car.state;
	if(client.license is qualified && car.state == 0) {
		//rentCar;
		change car.state to 1;
		return "rent car successfully";
	}else if ( client.license is not qualifited) {
		return "rentCar fail";
	}else if ( car.state == 2) {
		return "car is not availabel";
	}
}

Behaviour: checkCar(car.licensePlate){
	searchCar(car.licensePlate);
	check the state of a return car;
	if (car.state is great) {
		car.state = 0;
	}else 
		car.state = 2;
	return car.state;
}

Behaviour: returnCar(car.licensePlate){
	int state = checkCar(licensePlate);
	if (state == 0) {
		return "return a car successfully"
	}
}
}

public class AccountService{ // for both renter and client
state: email, username, password;
Behaviour: accountRegister(email, username, password){
	switch(renter or client)
	if (renter) {
		RentalSystem.initiate(List<Renter> renter, 0); // 0 means renter;
	}else {
		RentalSystem.initiate(List<Client> client, 1); // 1 means client;
	}
	return "register success";
}

Behaviour: login(username, password){
	if (username is valid && password is valid) {
		return "login in success";
	}els
		return "username or password is not valid, login in fail";
}
}

public class creditCardService{
state: cardNumber, ExpireDate, NameOfCard, CVV
Behaviour: identifyCard(cardNumber, ExpireDate, NameOfCard, CVV){
	if (cardNumber matched NameOfcard and CVV) {
		if(date > ExpireDate)
			return "the card is expired";
		else
			return "add a card successfully"
	}else
		return "the card is not valid";
	
}

Behaviour: checkout(price, cardNumber){
	if (identifyCard(cardNumber).equal("add a card successfully") && price < card.balance;)	
			return "checkout approved";
}
}

private class renter{
state: username, password, email;
Behaviour: login(){
	if (first login in) {
		AccountService.accountRegister(email, username, password);
	}else {
		AccountService.login(username,password);
	}
}

Behaviour: confirmOrder(Car.licensePlate){
	int state = RentalSystem.checkCar(Car.licensePlate));
	String isOk = RentalSystem.rentCar(client.license, car.licensePlate);
	if (state == 0) {
		if (isOK.equal("rent car successfully"))
			System.out.println("order approved");
	}
	
}

Behaviour: confirmReturnRequested(){
	int state = RentalSystem.checkCar(Car.licensePlate));
	if (state == 0) {
		System.out.println("return the car approved");
	}
}
}

private class client{
state: 	username, password, license, phoneNumber, email;
Behaviour: login(){
	if (first login in) {
		AccountService.accountRegister(email, username, password);
	}else {
		AccountService.login(username,password);
	}
}

Behaviour: rentCar(license){
	List<Car> carInfo = searchCar basing on parameters;
	RentalSystem.rentCar(carInfo.licensePlate);
}

Behaviour: reviewOrder(username){
	car.NameOfclient = username;
	List<Car> carInfo = searchCar basing on NameOfClient;
	return carInfo;
}
	
Behaviour: cancleOrder(username){
	List<Car> carInfo = reviewOrder(username);
	set carInfo.state = 0;
}
	
Behaviour: returnOrder(username){
	List<Car> carInfo = reviewOrder(username);
	RentalSystem.returnCar;
}

Behaviour: PayOrder(orderNumber){
	List<Car> carInfo = reviewOrder(username);
	System.out.println(carInfo.price);
	//client pay money according carInfo.price;
	creditCardService.identifyCard;
}

}







