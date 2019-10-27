

public class Analysis {
	private String statement;
	private int index=0;
	private int parentheses=0;
	
	public Analysis(String expression){
		statement=expression;
	}
	
	public void show(){
		try {
			E();
			System.out.println("Successful!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	private void E() throws Exception{
		T();
		Ep();
	}
	private void Ep() throws Exception{
		if(statement.charAt(index)=='+'||statement.charAt(index)=='-'){
			index++;
			T();
			Ep();
		}else{
			if(statement.charAt(index)==')'&&parentheses%2!=1)
				throw new Exception("括号匹配错误");
			if(statement.charAt(index)!='#'&&statement.charAt(index)!=')')
				throw new Exception("存在非法符号！");
		}
	}
	private void T() throws Exception{
		F();
		Tp();
	}
	private void Tp() throws Exception{
		if(statement.charAt(index)=='*'||statement.charAt(index)=='/'){
			index++;
			F();
			Tp();
		}else{
			if(statement.charAt(index)==')'&&parentheses%2!=1)
				throw new Exception("括号匹配错误");
			if(statement.charAt(index)!='#'&&statement.charAt(index)!=')'&&statement.charAt(index)!='+'&&statement.charAt(index)!='-')
				throw new Exception("存在非法符号！");
		}
	}
	private void F() throws Exception{
		int flag=0;
		if(statement.charAt(index)=='('){
			parentheses++;
			index++;
			E();
			if(statement.charAt(index)!=')'){
				throw new Exception("括号匹配错误！");
			}
			parentheses--;
			index++;
			return;
		}
		if(statement.charAt(index)<='9'&&statement.charAt(index)>='0'){
			index++;
			while((statement.charAt(index)<='9'&&statement.charAt(index)>='0')||statement.charAt(index)=='.'){
				if(statement.charAt(index)=='.'){
					if(flag==1){
						throw new Exception("浮点数错误！多了小数点");
					}
					else if(flag==0){
						if(!(statement.charAt(index+1)<='9'&&statement.charAt(index+1)>='0')){
							throw new Exception("浮点数错误！小数点后无数字");
						}
					}
					flag++;
				}
				index++;
			}
			return;
		}
//		throw new Exception("运算符错误！");
		else {
			throw new Exception("存在非法符号！");
		}

	}

}
