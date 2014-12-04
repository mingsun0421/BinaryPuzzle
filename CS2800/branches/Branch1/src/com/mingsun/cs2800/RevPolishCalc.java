package com.mingsun.cs2800;

public class RevPolishCalc implements Calculator{
	NumStack values;
	
	public final float evaluate(String what) throws MyException{
		values = new NumStack();
		String[] tokens = what.split("\\s+");
		String operators = "+-*/";
        for(String str : tokens){
            if(!operators.contains(str)){
                values.push(Float.valueOf(str));
            }else{
                float first = values.pop();
                float second = values.pop();
                int index = operators.indexOf(str);
                switch(index){
                    case 0:
                        values.push(first+second);
                        break;
                    case 1:
                        values.push(second-first);
                        break;
                    case 2:
                        values.push(first*second);
                        break;
                    case 3:
                        values.push(second/first);
                        break;
                }
            }
        }
		return values.pop();
	}
}
