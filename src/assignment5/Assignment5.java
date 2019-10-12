package assignment5;

/*
 * 
 * Q1, difference between final and finally;
 * Designed by Kai Tian;
 * Final is used to limit an object such that the object could not be modified by other class;
 * If the object is a variable, it could not be changed after it initialized;
 * If the object is a method, it could not be overridden;
 * if the object is a class, it could not be inherited;
 * 
 * Finally is a block; 
 * Finally is used to execute code whether the exception is handling or not;
 * 
 */

/*
 * Q10, extra credit;
 * Designed by Kai Tian;
 * the result should be 6;
 * b.getAddCount should be 6:
 * After the function addAll in Class B, addCount is 3;
 * Then because the addAll is overridden by class B, so 'this' in class A should invoke function add in B;
 * then addCount should be 3+1+1+1 = 6;
 * 
 * b.getI() should be 0, because class B invokes the Function of getI in Parent' s class A and the function is not overridden by class B
 * so the i should be 0, which is initialized in A; 
 * 
 * So the result should be 6+0 = 6;
 */