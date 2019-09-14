/*
 * A Course TrafficControllerSystem;
 * Pseudo code;
 * Designed by Kai Tian;
 */

Object for System{
	TrafficControllerService;
	Vehicle;
	Pedestrian;
}

------------------------------------------------------------------------------------

Object of TrafficControllerService{
	TrafficLight.color;
	TrafficLight.time;
	TrafficLightForPedestrian.type;
	camera;
}
 
Function of TrafficControllerService{
	changeTrafficLightColor;
	takePhoto;
	timer;
}
------------------------------------------------------------------------------------

Object of Vehicle{
	Vehicle.licensePlate;
}
 
Function of Vehicle{
	accrossRoad;
	turnLeft;
	turnRight;
	turnRound;
	wait;
}
----------------------------------------------------------------------------------

Object of Pedestrian{	 

}
 
Function of Pedestrian{	 
	accrossRoad;
	wait;
}
 
Class TrafficControllerService{
Behaviour: changeTrafficLightColor(TrafficLight.color, TrafficLight.time){
	turn on timer;
	whilt(true){ 		
		if (color == "green" && time > 30s) {
			TrafficLight.color = "yellow";
			timer = 0;
			continue;
		}
		if (color == "yellow" && time > 3s) {
			TrafficLight.color = "red";
			TrafficLightForPedestrian.type = "go"; //set light in the corner for pedestrians;
			timer = 0;
			continue;
		}
		if (color == "red" && time > 40s) {
			TrafficLight.color = "green";
			TrafficLightForPedestrian.type = "stop"; //set light in the corner for pedestrians;
			timer = 0;
			continue;
		}
	}
}

Behaviour: takePhoto(TrafficLight.color){
	if (color == "red" && vehicle is accross road) {
		turn on camera to take a phone;
	}
}

private Class Vehicle{
state: licensePlate
Behaviour: accrossRoad(TrafficLight.color){
	if (color == "green" || color == "yellow") {
		go;
	}else
		wait;
}

Behaviour: accrossRoad(TrafficLight.color){
	if (color == "green" || color == "yellow") {
		go;
	}else
		wait;
}

Behaviour: turnLeft(TrafficLight.color){
	if (color == "green" || color == "yellow") {
		go;
	}else
		wait;
}

Behaviour: turnRight(TrafficLight.color){
	go;
}

Behaviour: turnRound(TrafficLight.color){
	if (color == "green" || color == "yellow") {
		go;
	}else
		wait;
}
}

private class Pedestrian{
Behaviour: accrossRoad(){
	if ( TrafficLightForPedestrian.type == "stop")
		wait();
	else 
		go;
}
}
 
 
 
 
 