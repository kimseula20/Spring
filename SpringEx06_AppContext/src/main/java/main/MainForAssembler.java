package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import SpringEx06_AppContext.ChangePasswordService;
import SpringEx06_AppContext.DuplicateMemberException;
import SpringEx06_AppContext.MemberInfoPrinter;
import SpringEx06_AppContext.MemberListPrinter;
import SpringEx06_AppContext.MemberNotFoundException;
import SpringEx06_AppContext.MemberRegisterService;
import SpringEx06_AppContext.RegisterRequest;
import SpringEx06_AppContext.WrongIdPasswordException;
import config.AppContext1;
import config.AppContext2;

public class MainForAssembler {

	private static ApplicationContext ctx = null;
	
	private static void printHelp() {
		System.out.println("----------------------------------------");
		System.out.println("잘못된 명령입니다. 아래 명령어 사용법을 확인하세요");
		System.out.println("명령어 사용법 : ");
		System.out.println("new 이메일 이름 암호 암호확인");
		System.out.println("change 이메일 현재비번 변경비번");
		System.out.println("info 이메일");
		System.out.println("----------------------------------------");
	}
	private static void processNewCommand(String[] arg) {
		if(arg.length != 5) {
			printHelp();
		}
		MemberRegisterService regSvc = ctx.getBean("memberRegSvc", MemberRegisterService.class);
		RegisterRequest request = new RegisterRequest();
		request.setEmail(arg[1]);
		request.setName(arg[2]);
		request.setPassword(arg[3]);
		request.setConfirmPassword((arg[4]));
		if(!request.isPasswordEqualToConfirmPassword()) {
			System.out.println("암호와 확인이 일치하지 않습니다. \n");
			return;
		}
		try {
			regSvc.regist(request);
			System.out.println("등록이 완료되었습니다.\n");
		}catch(DuplicateMemberException e) {
			System.out.println("이미 존재하는 이메일입니다. \n");
		}
	}
	
	private static void processChangeCommand(String[] arg) {
		if(arg.length != 4) {
			printHelp();
			return;
		}
		ChangePasswordService changePwdSvc = ctx.getBean("changePwdSvc", ChangePasswordService.class);
		try {
			changePwdSvc.changePassword(arg[1], arg[2], arg[3]);
			System.out.println("암호를 변경했습니다.\n");
		}catch(MemberNotFoundException e) {
			System.out.println("존재하지 않는 이메일입니다.\n");
		}catch(WrongIdPasswordException e) {
			System.out.println("이메일과 암호가 일치하지 않습니다.\n");
		}
	}
	
	private static void processListCommand() {
		MemberListPrinter listPrinter = ctx.getBean("listPrinter", MemberListPrinter.class);
		listPrinter.printAll();
	}
	
	private static void processInfoCommand(String[] arg) {
		if(arg.length != 2) {
			printHelp();
			return;
		}
		MemberInfoPrinter infoPrinter = ctx.getBean("infoPrinter", MemberInfoPrinter.class);
		infoPrinter.printMemberInfo(arg[1]);
				
	}
	public static void main(String[] args) throws IOException{
		
		ctx = new AnnotationConfigApplicationContext(AppContext1.class, AppContext2.class);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("명령어를 입력하세요");
			String command = br.readLine();
			if(command.equalsIgnoreCase("exit")) {
				System.out.println("종료합니다");
				break;
			}
			else if(command.startsWith("new ")) {
				processNewCommand(command.split(" "));
				continue;
			}
			else if(command.startsWith("change ")) {
				processChangeCommand(command.split(" "));
				continue;
			}
			else if(command.equals("list")) {
				processListCommand();
				continue;
			}
			else if(command.startsWith("info ")) {
				processInfoCommand(command.split(" "));
				continue;
			}
			printHelp();
		}
	}
}
