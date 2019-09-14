/*
 * A vending Machine;
 * Pseudo code;
 * Designed by Kai Tian;
 */

Object of Machine{
	vendingService;
	consumer;
	seller;
}
--------------------------------------------------------------------

Object of VendingService{
	Goods.number;
	Goods.name;
	Goods.price;
	Goods.quantity;
	Goods.expirationDate;
	Machine.money; //this object means balance of machine;
}

Function of VendingService{
	addGoods;
	settingGoods;
	sellGoods;
	registerMember; //Consumers can register for a member if they want;
}
--------------------------------------------------------------------

Object of Seller{
	Seller.name;
	Seller.password; // to open the machine for seller;
	Seller.email;
	Seller.phoneNumber;
}

Function of Seller{
	addGoods;
	settingGoods;
	withdrawMoney; //to take money away
}
--------------------------------------------------------------------

Object of Consumer{ // the vending machine allows consumers to become a member;
	Consumer.accountname;
	Consumer.password;
	Consumer.balance;
}

Function of VendingService{
	buyGoods;
	registerMember;
}
--------------------------------------------------------------------

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

public class memberService{
State: accountname, password, balance, isDiscount;
Behaviour: registerMember(accountname, password){
	List<Consumer> consumer;
	consumer.accountname = accountname;
	consumer.password = accountname;
	set{consumer.accountname
		consumer.password		
	}to database;
	set consumer.isMember = true; 
}

Behaviour: topUpService(value, balance){
	balance = balance +value;
	return balance;
}

Behaviour: checkout(totalValue, balance, isDiscount){
	if (isDiscount)
		balance = balance - totalValue * isDiscount; //discount means percent of total price;
	else
		balance = balance - totalValue;
	System.out.println("checkout approved");
	return balance;
	
}

Class VendingMachine{
Behaviour: addGoods(List<Goods> goods){
	set {	Goods.number;
	Goods.name;
	Goods.price;
	Goods.quantity;
	Goods.expirationDate;
	Machine.money;
	}
	to database;
}

Behaviour: settingGoods(Goods.exirationDate, Goods.quantity){
	if (date > Goods.exirationDate) {
		send "goods.number need to update" to seller;// if goods is out of date, contact seller to update;
		update goods.expirationDate;
	}
	if (Goods.quantity <= 0) {
		send "goods.number need to supply" to seller;// if goods is sold out, contact seller to supply;
		update goods.quantity;
	}
}

Behaviour: sellGoods(Goods.number){
	push Goods out of basket base of goods.number;
	int price = Goods.prices;
	switch (creditService.checkout or cashService.checkout or memberService.checkout)
	//according to the kind of payment to pay the bill;
	Goods.quantity --;
}


Behaviour: registerMember(accountname, password, balance, isDiscount){
	memberService.registerMember(accountname, password);
	memberService.topUpService(value, balance);
}

private class seller{
State: name, password, email, phoneNumber;
Behaviour addGoods(List<Goods> goods) {
	List<Goods> goodsInfo = goods
	VendingMachine.addGoods(goodsInfo);
}

Behaviour settingGoods(Goods.exirationDate, Goods.quantity) {
	VendingMachine.settingGoods(Goods.exirationDate, Goods.quantity);
}

Behaviour withdrawMoney(name, password, withdrawValue) {
	Machine.money = Machine.mone - withdrawValue;
	set {seller.name
		seller.password
		withdrawValue
	}
	to database; // record information for review in the future;
	update Machine.money to database;
}
}

private class consumer{
State: 	accountname, password, balance;
Behaviour: registerMember(accountname, password, balance){ //consumer can ignore the option;
	VendingMachine.registerMember(accountname, password, balance);
}

Behaviour: buyGoods(goods.number){
	VendingMachine.sellGoods(Goods.number)
}

}






