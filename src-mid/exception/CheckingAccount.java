package exception;

public class CheckingAccount extends Account {
	double overdraftProtection;
	//构造方法设置可透支额度
	public CheckingAccount() {
		overdraftProtection=0;
	}
	public CheckingAccount(double x) {
		overdraftProtection=x;
	}
	public double getOverdraftProtection() {
		return overdraftProtection;
	}
	//overide存款
	public void deposit(double m) {
		balance+=m;
		System.out.printf("现金存款："+m+"元                       \t账户余额："+getBalance()+"元"+"\t账户信用额度：%.2f元%n",overdraftProtection);
	}
	//overide取款
	public void withdraw(double m) throws OverdraftException{
		
		if(balance>0&&m<=balance) {
			balance-=m;
			System.out.printf("账户余额直接取出：%.2f元      \t",m);
			System.out.printf("账户余额："+balance+"元"+"\t账户信用额度：%.2f元%n",overdraftProtection);
			}
		else if(m>balance&&m<=balance+overdraftProtection) {
			overdraftProtection-=(m-balance);
			System.out.printf("信用透支%.2f元取出：%.2f元\t",m-balance,m);
			balance=0;
			System.out.printf("账户余额："+balance+"元"+"\t账户信用额度：%.2f元%n",overdraftProtection);
			}
		else if(m>balance+overdraftProtection) {
			double deficit=m-balance-overdraftProtection;
			System.out.printf("欠费%.2f元取出：%.2f元\t",m-balance-overdraftProtection,m);
			balance=0;
			overdraftProtection=0;
			throw new OverdraftException("账户欠费，欠费额：",deficit);
			}
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Account xiaoming=new CheckingAccount(100);
		try {
			xiaoming.deposit(100);
			xiaoming.withdraw(5.21);
			xiaoming.withdraw(95);
			xiaoming.withdraw(103.5);
		} catch (OverdraftException e) {
			// TODO 自动生成的 catch 块
			System.out.printf("欠费：%.2f元%n",e.getDeficit());
			e.printStackTrace();
		}
	}

}
