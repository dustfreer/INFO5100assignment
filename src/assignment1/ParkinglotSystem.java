/*
 * A parking lot System;
 * Pseudo code;
 * Designed by Kai Tian;
 */

Object of System{
	ParkingService;
	Client;
}
------------------------------------------------------------------------------------

Object of ParkingService{
	ParkingLot.spotID;
	ParkingLot.fee;
	ParkingLot.time;
	ParkingSpot.plateNumber;
	ParkingLot.availableSpotNumber;
}

Function of ParkingService{
	ParkingCar;
	DisplayParkingSpotNumber;
	FindACar;
	MemberService; // memberService allow clients to pay monthly;
	CalculateFee;
}
------------------------------------------------------------------------------------

Object of Client{
	Client.accountName;
	Client.password;
	Client.mail;
	Client.isMember;
}

Function of Client{
	ParkingCar;
	FindMyCar;
	RegisterMember;
	Payfee;
}
------------------------------------------------------------------------------------

public class creditCardService{
State: cardNumber, ExpireDate, NameOfCard, CVV
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

public class cashService{
State: cashValue, totalValue, cashNumber;
Behaviour: checkout(totalValue, cashValue, cashNumber){
	double tax = 0.1; // assume tax is 10%.
	balance = totalValue - cashValue * cashNumber * ( 1 + tax);
	if (balance != 0) {
		changefund;
	}else {
		return "checkout approved";
	}
}
}

public class member{
State: accountname, password, balance;
Behaviour: registerMember(accountname, password){
	List<Client> client;
	client.accountname = accountname;
	client.password = accountname;
	set{client.accountname
		client.password		
	}to database;
	set client.isMember = true; 
}

Behaviour: topUpService(value, balance){
	balance = balance +value;
	return balance;
}

Behaviour: checkout(totalValue, cashValue){
	if ( current - register.time < 30 days)
		return;
	else
		balance = balance - monthlyFee;
}
}

Class ParkingService{
Behaviour: memberService(List<Client> client)
	Member.registerMember(client.accountname, client.password);
	Member.topUpService(value, balance);
}

Behaviour: parkingCar(plateNumber){
	// scan plate number from camera;
	ParkingSpot.plateNumber = plateNumber;
	ParkingLot.time = getCurrentTime;
	
}

Behaviour: findAcar(plateNumber);
	search a car basing on plateNumber from database;
	return ParkingLot.spotID;
	
Behaviour: displayParkingSpotNumber(){
	search available parking spot number from database;
	return availableSpotNumber;
}
	
Behaviour: calculateFee(ParkingLot.time){
	double fee = (getCurrentTime - ParkingLot.time)/ 60 * feePerhour;
	return fee;
}
}

private class Client{
State: username, password, email;
Behaviour: registerMember(username, password, mail){
	ParkingService.memberService;
}

Behaviour: ParkingCar(){
	ParkingService;
}
Behaviour: FinaMyCar(){
	findAcar(plateNumber);
}

BehaviourL Payfee() {
	switch (creditService.checkout or cashService.checkout or memberService.checkout)
	//according to the kind of payment to pay the bill;
}
}




