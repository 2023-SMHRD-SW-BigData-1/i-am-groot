package MiniProject;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

import javazoom.jl.player.MP3Player;

public class Game_Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		DAO dao = new DAO();
		int choiceGenre = 0;
		int choiceLevel = 0;
		Music m = new Music();
		MP3Player mp3 = new MP3Player();
		int[] ran = new int[10];
		 for(int a = 0; a < 10 ;a++) {
				ran[a] = rd.nextInt(10);
				
				for(int j = 0; j < a;j++) {
					if (ran[a] == ran[j]) {
						a -= 1;
					}
				}
			}
		
		int point = 0;
		// 게임시작 전 선택 페이지

		System.out.println(

				"\r\n" + ".___  ___.  __    __       _______. __    ______      _______      ___      .___  ___.  _______ \r\n"
						+ "|   \\/   | |  |  |  |     /       ||  |  /      |    /  _____|    /   \\     |   \\/   | |   ____|\r\n"
						+ "|  \\  /  | |  |  |  |    |   (----`|  | |  ,----'   |  |  __     /  ^  \\    |  \\  /  | |  |__   \r\n"
						+ "|  |\\/|  | |  |  |  |     \\   \\    |  | |  |        |  | |_ |   /  /_\\  \\   |  |\\/|  | |   __|  \r\n"
						+ "|  |  |  | |  `--'  | .----)   |   |  | |  `----.   |  |__| |  /  _____  \\  |  |  |  | |  |____ \r\n"
						+ "|__|  |__|  \\______/  |_______/    |__|  \\______|    \\______| /__/     \\__\\ |__|  |__| |_______|\r\n"
						+ "                                                                                                \r\n"
						+ "" + "⠄⠀⠀⠀⠀⢀⣤⣶⣾⣿⣷⣶⣶⣤⣀⠀⣀⣴⣶⣿⣿⣶⣦⣄⠀⠀⠀⠀⠀⠀\r\n" + "⠀⠀⠀⢀⣴⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⡀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⢀⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣄⡀⠀⠀\r\n" + "⠀⣠⣿⣿⣿⠟⠉⠁⠈⠉⠉⠉⠙⠛⢻⣿⣿⣿⣿⣿⣿⠛⠛⠛⠛⠛⠋⠑⠀⠀\r\n"
						+ "⢸⣿⣿⣿⣿⣷⠶⠾⠷⠶⠶⠶⠒⠒⠛⢿⣿⣿⣿⣿⣿⠦⢠⠖⠲⠶⢶⣿⣶⡄\r\n" + "⣼⣿⣿⣿⠋⠀⠀⠀⠀⠀⠀⢰⠖⠀⠀⠀   ⣿⣿⣿⡟⠙⠸⡏⠀⠀⠰⠀⣈⣿⠇\r\n"
						+ "⣿⣿⣿⣿⣿⣿⣿⣶⣶⣴⣶⡿⣀⣤⣤⣾⣿⣿⣿⣿⣤⣤⣿⣶⣶⣿⣿⠿⠋⠀\r\n" + "⣿⣿⣿⣿⣿⣿⡿⠿⠿⣿⣿⣿⣿⣿⠿⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣇⠀⠀⠀\r\n"
						+ "⣿⣿⣿⣿⣿⡏⣴⣶⣶⣬⠻⣿⣿⣧⣾⣿⣿⣿⣿⣿⣿⣿⠿⠿⢿⣿⣿⣆⠀⠀\r\n" + "⠻⣿⣿⣿⣿⠃⠘⢿⣿⣿⣷⠘⠿⣿⣯⣽⣾⣿⠿⠋⣉⣤⣴⣶⡆⢹⣿⣿⡆⠀\r\n"
						+ "⣀⠽⣿⣿⣿⣷⡆⢸⣿⣿⣿⡇⢀⣀⠀⠀⠈⣀⣴⣾⣿⣿⠿⠛⠁⣈⣉⠛⠁⠀\r\n" + "⣻⣿⣿⣿⣿⡿⠁⣼⣿⣿⣿⠁⣈⣀⣤⣾⣿⣿⠿⠟⠉⣀⣤⣶⣿⠿⠛⠀⠀⠀\r\n"
						+ "⣿⣿⣿⣿⠏⠁⢀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣯⣶⣶⡄⢹⡿⠟⠋⠁⠀⠀⠀⠀⠀\r\n" + "⣿⣿⣿⣿⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡃⠸⣀⣀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⣿⣿⣿⣿⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⣿⣿⣷⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀");

		System.out.println();

		while (true) {
			
			System.out.println("=========== MUSIC GAME 이야기 =============");
			System.out.println("난생 처음 보는 코드들에 속수무책으로 죽어가는 세연쌤반 학생들! 스트레스에 못 이겨 의욕을 잃어간다!");
			System.out.println("쉬는시간을 조금이나마 더 즐기기 위해서는 위험을 감지하는 좋은 귀를 가진 동료가 필요한 상황! ");
			System.out.println("잠깐의 소리로도 선생님이 오시는지 기척을 잡아채는 귀를 가진 동료를 얻기 위한 모험을 떠나는데 ..!");
			System.out.println("=========================================");
			
			
			System.out.println("계속 진행하려면 아무 키나 입력하고 엔터를 누르세요");
			String anyKey = sc.next();
			if(anyKey!=null) {
			
			System.out.println();
			System.out.print("[1]너 내 동료가 돼라! [2]모험의 시작 [3]전체랭킹보기 [4]게임설명 >> ");
			int input = sc.nextInt();
			// 회원가입
			if (input == 1) {
				System.out.println("===== 동료 명부에 이름 올리기 =====");

				System.out.print("네 이름은 무엇이냐 : ");
				String id = sc.next();
				System.out.print("우리끼리의 비밀 암호를 정해보자 : ");
				String pw = sc.next();

				PlayerDTO pdto = new PlayerDTO(id, pw);
				int cnt = dao.join(pdto);

				if (cnt > 0) {
					System.out.println("귀 활짝 열어놓으라구!");
					PlayerDTO pdt = new PlayerDTO(id, point);
					int low = dao.pointID(pdt);
					if (low > 0) {
						System.out.println("저장완료");
					} else {
						System.out.println("저장실패");
					}
				} else {
					System.out.println("동료가 되기 싫은거야? 다시 시도해보라구!");
				}
				// 로그인
			} else if (input == 2) {

				System.out.println("===== 동료가 맞는지 확인하겠소 =====");
				System.out.print("네 이름이 무엇이냐 : ");
				String id = sc.next();
				System.out.print("암호를 입력하거라 : ");
				String pw = sc.next();
				PlayerDTO pdto = dao.login(id, pw);
				if (pdto != null) {
					System.out.println("떠나보자고!");

					while (true) {
						System.out.println("======= 장르 선택 =======");
						System.out.println("[1]발라드 [2]댄스 [3]힙합");
						choiceGenre = sc.nextInt();

						if (choiceGenre == 1) {
							System.out.println("\r\n" + "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
									+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
									+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠿⠿⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
									+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⣀⡈⠙⠻⢿⣿⣿⣿⣿⠟⠁⠀⠀⠀⠀⠀⠈⠻⣿⣿⣿⣿⡿⠿⠛⠛⠛⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
									+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⢰⣿⣿⣷⣦⣄⠈⠛⠿⠃⡀⠀⠀⠀⠀⠀⠀⠀⠀⠹⠟⠋⢁⣠⣤⣶⣦⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
									+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⢸⣿⣿⣿⠿⠋⠁⠀⠀⠀⠀⠀⠈⠀⠀⠀⠀⠀⠀⠂⠀⠀⠙⠿⣿⣿⣿⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
									+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⡄⠸⣿⠟⠁⠀⠀⠀⠀⠒⠂⠀⠀⠀⠈⠐⠒⠒⠀⠀⠀⠒⠂⠀⠀⠈⠻⡿⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
									+ "⣿⣿⣿⣿⣏⡉⠉⠹⠿⠇⠀⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
									+ "⣿⣿⣿⣿⣿⣿⣷⣶⣦⡜⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠠⠀⠀⢹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
									+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠐⢄⡀⠀⠀⠀⢀⣠⠎⠀⠀⠀⠀⠀⠀⠐⠤⣀⡀⠀⠀⣀⡔⠀⠀⠀⢿⣿⣿⣿⡿⠿⠿⣿⣿⣿⣿\r\n"
									+ "⣭⣭⣉⣉⣉⣭⣭⣯⡇⠀⠀⠀⠀⠀⠀⠉⠉⠛⠉⠉⠀⠀⠀⡖⠒⠒⢲⠂⠀⠀⠀⠉⠉⠉⠁⠀⠀⠀⠀⠸⣿⠟⠛⠁⣀⣀⣼⣿⣿⣿\r\n"
									+ "⣿⣿⣿⣿⣿⣿⣿⣿⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣧⣄⠀⠸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣧⣴⣶⣿⣿⣿⣿⣿⣿⣿\r\n"
									+ "⣿⣿⣿⣿⣿⣿⣿⣿⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣸⣿⣿⣿⢇⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠛⠉⠙⠛⢿⣿⣿⣿⣿⣿\r\n"
									+ "⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠠⠀⠀⠀⠀⠀⢿⣿⣿⠿⠞⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⡤⣶⣿⣿⣿⣿⣿⣿\r\n"
									+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠿⡏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠄⢺⣿⣇⣿⣿⣷⣾⣿⣿⣿\r\n"
									+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⡀⠀⠀⠀⠀⠀⠀⠀⠀⠤⣤⡤⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
									+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣄⠀⠀⠀⠀⠀⠀⠀⠸⢿⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
									+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
									+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣯⣽⣅⣱⣦⣀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣴⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
									+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠟⣋⣭⣵⣶⠀⠈⠈⠉⠉⠁⠈⠀⠀⠀⠉⠉⠉⠉⠉⠛⠛⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
									+ "⣿⣿⣿⣿⣿⣿⡿⣿⠿⠿⠿⢯⣶⣿⣿⣿⣿⡏⠀⠀⠀⠀⠀⡀⠀⠀⠀⠀⠀⠀⣄⠀⠀⠀⠀⢨⣿⣿⣿⣿⣿⣿⣿⠛⠛⠛⠿⠿⣿⣿\r\n"
									+ "⢿⣻⣭⠍⠁⠀⣀⣀⣀⣠⣶⣿⣿⣿⣿⣿⣿⠇⠀⠀⠀⠀⢸⣿⣧⠀⠀⠀⠀⠀⠈⠎⠤⢄⠀⢠⣿⣿⣿⣿⣿⣿⡇⠀⢀⣤⠀⠀⠀⠀\r\n"
									+ "⣿⣿⣿⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣰⣶⡀⠀⠀⠘⠿⠟⠀⠀⠀⠀⢀⣤⣴⣤⠈⠆⣿⣿⣿⣿⣿⣿⣿⠵⢠⡌⠉⢀⣀⣀⡀\r\n"
									+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣤⣄⣀⣄⢀⠀⠀⠀⢀⣼⣿⣿⣿⣇⣼⣿⣿⣿⣿⣿⣿⣿⣷⣿⣧⠀⢸⣿⣿⣿\r\n"
									+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣿⣿⣷⣾⣿⣿⣿⣿⣿⣻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣬⣿⣿⣿\r\n" + "");
							break;
						} else if (choiceGenre == 2) {

							System.out.println("\r\n" + "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
									+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
									+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠒⠒⠒⠒⠤⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
									+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠠⠖⠒⠒⠤⣀⠀⠱⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
									+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢧⠀⠘⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
									+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
									+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡴⠒⠒⠲⢄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
									+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⠀⠀⠀⠀⠈⢳⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
									+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⣆⠀⠀⠀⠀⠀⢷⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
									+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⠤⠒⠚⠉⠉⠒⠒⠤⣄⡀⠀⠀⠀⠀⠀⠸⡄⠀⠀⠀⠀⢸⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
									+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⠞⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠲⣄⠀⠀⠀⢠⡇⠀⠀⠀⠀⠈⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
									+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡜⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡆⠀⠈⠳⣄⢀⡞⠀⠀⠀⠀⠀⢸⡧⠶⠦⢤⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
									+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⡼⠀⠀⠀⠀⠀⠀⠀⠀⠀⠐⠒⠒⠋⠀⠀⠀⠀⠘⠋⠀⠀⠀⠀⠀⠀⢸⠀⠀⠀⠀⠙⣆⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
									+ "⠀⠀⠀⠀⠀⠀⠀⠀⢰⠇⠀⠀⠀⠀⠀⡀⠀⠀⠀⠀⣀⣠⣤⣤⣤⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⡟⠀⠀⠀⠀⠀⠸⡆⠀⠀⠀⠀⠀⠀⠀\r\n"
									+ "⠀⠀⠀⠀⠀⠀⠀⠀⢸⠀⠀⠀⠀⠀⣠⠇⠀⢀⣴⣾⣿⣿⣿⣿⣿⠟⠀⠀⠀⠀⠀⠀⠀⠀⣸⠁⠀⠀⠀⠀⠀⠀⡇⠀⠀⠀⠀⠀⠀⠀\r\n"
									+ "⠀⠀⠀⠀⠀⠀⠀⠀⠘⡇⠀⠀⠉⠉⠁⠀⣴⣿⣿⣿⣿⣿⠟⠋⠀⠀⠀⠀⠀⠀⠀⠀⠹⣴⠃⠀⠀⠀⠀⠀⠀⠀⡇⠀⠀⠀⠀⠀⠀⠀\r\n"
									+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⢳⡀⠀⠀⠀⠀⣼⣿⣿⣿⠟⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⣆⠀⠀⠀⠀⠀⠀⠀⡇⠀⠀⠀⠀⠀⠀⠀\r\n"
									+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠳⡄⠀⠀⠀⠙⠛⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⡄⠀⠀⠀⠀⠀⢠⡇⠀⠀⠀⠀⠀⠀⠀\r\n"
									+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⢦⡀⠀⠀⠀⠀⠀⠘⢦⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢳⠀⠀⠀⠀⠀⢸⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
									+ "⠀⠀⠀⠀⠀⠀⡼⠁⠀⣠⠀⠀⠀⠹⡄⠀⠀⠀⠀⠀⠀⠈⠙⠒⠒⠦⠤⣄⠀⠀⠀⠀⠀⠀⠀⠘⡆⠀⠀⠀⠀⡟⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
									+ "⠀⠀⠀⠀⠀⡼⠁⢀⠞⠁⠀⠀⠀⠀⠹⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣧⠀⠀⠀⠀⠀⠀⠀⣇⠀⠀⠀⢰⠃⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
									+ "⠀⠀⠀⠀⠀⡇⠀⣼⠀⠀⠀⠀⠀⠀⠀⣷⠀⠀⠲⣄⡀⠀⠀⠀⠀⠀⠀⢀⡏⠀⠀⠀⠀⠀⠀⠀⣿⠀⠀⣠⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
									+ "⠀⠀⠀⠀⠀⣧⠀⠸⡀⠀⠀⠀⠀⠀⠀⡏⠀⠀⠀⠀⠉⠓⠲⠦⠤⠴⠖⠋⠀⠀⠀⠀⠀⠀⠀⠀⡿⣀⠔⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
									+ "⠀⠀⠀⠀⠀⠘⣆⠀⠙⠦⠀⠀⠀⠀⣸⣵⣶⣿⣶⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
									+ "⠀⠀⠀⠀⠀⠀⠈⠃⠀⠀⠀⠀⠀⢠⣿⣿⣿⣿⣿⣿⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣶⣿⣿⣷⣦⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
									+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
									+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⣿⣿⣿⣿⣿⣿⡃⠀⠀⠀⠀⠀⠀⠀⠀⣠⠔⠋⠙⠻⠿⠿⠿⠿⠟⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
									+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠻⠿⠿⠿⠋⠉⠑⠒⠒⠒⠒⠒⠚⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
									+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
									+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + "");
							break;
						} else if (choiceGenre == 3) {
							System.out.println("\r\n" + "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣽⣿⠿⠟⠁⠀⠈⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
									+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
									+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣀⡀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
									+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣤⣴⣶⠀⠁⣸⠈⣿⣿⣿⣿⣿⠉⠈⡊⠠⡐⣦⣤⣤⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
									+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣾⣿⣿⣿⡂⢀⠀⠕⠀⣿⣿⣿⣿⣿⠐⢠⠈⠠⠆⣿⣿⣿⣿⣷⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
									+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣿⣿⣿⣿⡏⠉⡐⢐⡇⠁⣿⣿⣿⣿⡏⢐⠨⡂⠀⠓⣿⣿⣿⣿⣿⣿⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
									+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣸⣿⣿⣿⣿⠝⠁⠀⠰⡏⡀⢿⣿⣿⡯⠀⣀⡄⡢⢁⡂⣿⣿⣿⣿⣿⣿⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
									+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣰⣿⣿⣿⣿⣿⡩⡁⠀⠐⣗⠐⠸⣿⣿⡑⠂⢭⡕⠌⡷⡅⣿⣿⣿⣿⣿⣿⣿⣇⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
									+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣿⣿⣿⣿⣿⣿⣿⡆⣂⠠⠸⠄⠀⢊⢦⣡⣘⣻⣞⡯⢝⣒⣿⣿⣿⣿⣿⣿⣿⣿⡄⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
									+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣿⣿⣿⣿⣿⣿⣿⣟⡗⠤⠀⡅⢳⠊⠬⣩⠸⣤⣿⣥⡗⠦⢬⣿⣿⣿⣿⣿⣿⣿⣿⣿⡄⠀⠀⠀⠀⠀⠀⠀\r\n"
									+ "⠀⠀⠀⠀⠀⠀⠀⠀⠐⠟⠛⠻⠿⠛⠻⠿⠛⣻⠄⡍⣾⡒⡈⢿⣶⣿⣾⣿⢩⣿⠁⠺⠻⠿⠿⠿⠿⠛⠛⠻⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀\r\n"
									+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⣶⣾⣿⡑⠂⣿⣷⣄⠀⡭⢻⡩⡜⣳⡏⠒⢠⣄⡀⠀⠀⠀⠀⠀⠀⠈⢻⠇⠀⠀⠀⠀⠀⠀⠀\r\n"
									+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢻⣿⣿⣿⣿⣌⣱⣿⣿⣿⣷⣶⣾⣶⣾⣿⢧⣠⣼⣿⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
									+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠠⢖⣄⡀⠀⢿⣿⣿⣿⡧⠻⣿⣿⣿⣿⣿⣿⣿⣿⢟⠐⣒⣿⠏⢀⣾⣖⣡⠖⠀⠈⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
									+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⡯⣭⠟⡻⣿⣿⣿⣿⡟⣉⣻⣘⣉⠃⣰⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
									+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣾⣿⣿⣿⡟⠮⣯⣥⢇⡾⢹⣇⣷⣼⣾⠲⠮⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
									+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⣿⣿⣿⣿⣟⢒⣻⣿⣿⣿⣿⣿⣿⣿⣿⢱⢲⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
									+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣍⣝⣿⣿⣿⣿⣿⣿⣿⣿⡟⣼⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
									+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣿⣿⣿⣿⣿⣿⡖⠴⣿⣿⣿⣿⣿⣿⣿⣿⣸⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
									+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⡜⣻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
									+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣿⣿⣿⣿⣿⣿⣿⣿⣿⡽⢿⣿⣿⣿⣿⡟⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
									+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣾⢻⣿⡿⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
									+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
									+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠿⠿⢿⠿⠿⡿⠿⣿⡿⠿⢿⠿⢿⠟⠿⣿⡿⠿⡿⢿⠿⠿⠿⠤⠄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
									+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣾⡆⠀⣾⠀⠀⡇⠐⣿⡇⠀⠠⠀⠀⠘⠀⣿⡇⠐⡇⢸⠀⠒⡇⠀⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
									+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣇⣀⣿⣀⣀⣇⣈⣿⣇⣀⡠⣀⣠⣈⣀⣿⣇⣸⣇⣈⣀⣉⡁⠀⠐⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
									+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⠀⠸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + "");
							break;
						} else {

							System.out.println("번호를 잘못 입력했잖아. 제대로 선택해보라구!");

						}
					}

					while (true) {
						System.out.println("======= 난이도 선택 =======");
						System.out.println("난이도를 선택하세요");
						System.out.println("[1]easy [2]hard");
						choiceLevel = sc.nextInt();

						if (choiceLevel == 1) {
							System.out.println("easy모드가 선택되었습니다.");
							System.out.println("==== 게임규칙 ====");
							System.out.println("1.노래는 게임 시작 후 바로 재생됩니다.");
							System.out.println("2.답은 띄어쓰기 없이 작성해주세요.");
							System.out.println("3.답에 영어가 들어가 있다면 모두 한국어 발음으로 변경하여 작성해주세요.");
							System.out.println("게임을 즐겨주세요 !~");
							break;
						} else if (choiceLevel == 2) {

							System.out.println("hard모드가 선택되었습니다.");
							System.out.println("==== 게임규칙 ====");
							System.out.println("1.노래는 게임 시작 후 바로 재생됩니다.");
							System.out.println("2.답은 띄어쓰기 없이 작성해주세요.");
							System.out.println("3.답에 영어가 들어가 있다면 모두 한국어 발음으로 변경하여 작성해주세요.");
							System.out.println("4.노래 재생버튼을 누르면 다시 듣기가 가능합니다.");
							System.out.println("5.도저히 모르겠다면 p를 입력해주세요! 다음 문제로 넘어갑니다.");
							System.out.println("게임을 즐겨주세요 !~");
							break;
						} else {

							System.out.println("번호를 잘못 입력하셨습니다. 난이도를 선택해주세요.");
						}

					}
					System.out.println("===== 게임을 시작하려면 아무 키나 입력 후 엔터를 눌러주세요 =====");
					String gameStart = sc.next();
					if (gameStart != null) {

						System.out.println("\r\n"
								+ " __       _______      ___      .___  ___.  _______         _______..___________.     ___      .______      .___________.    __  \r\n"
								+ "|  |     /  _____|    /   \\     |   \\/   | |   ____|       /       ||           |    /   \\     |   _  \\     |           |   |  | \r\n"
								+ "|  |    |  |  __     /  ^  \\    |  \\  /  | |  |__         |   (----``---|  |----`   /  ^  \\    |  |_)  |    `---|  |----`   |  | \r\n"
								+ "|  |    |  | |_ |   /  /_\\  \\   |  |\\/|  | |   __|         \\   \\        |  |       /  /_\\  \\   |      /         |  |        |  | \r\n"
								+ "|__|    |  |__| |  /  _____  \\  |  |  |  | |  |____    .----)   |       |  |      /  _____  \\  |  |\\  \\----.    |  |        |__| \r\n"
								+ "(__)     \\______| /__/     \\__\\ |__|  |__| |_______|   |_______/        |__|     /__/     \\__\\ | _| `._____|    |__|        (__) \r\n"
								+ "                                                                                                                                 \r\n"
								+ "");
						
						for(int i = 1; i <4 ; i++) {
						
						if (choiceGenre == i && choiceLevel == 1) {
							for(int a = 0; a < 3; a++) {
								System.out.println("노래를 듣고 제목을 입력해주세요");
								System.out.println("재생은 1번 입니다.");
							int star = sc.nextInt();
							if(star == 1) {
							for(int j = 0; j < 3; j++) {
							mp3.play(dao.Easy_Ballad(ran[j]));
							System.out.println(dao.Easy_Ballad(ran[j]));
								
							System.out.print("정답을 입력해 주세요 : ");
							String userAnswer = sc.next();
							
							System.out.println("다시 들어보려면 R을 입력하세요");
							String replay = sc.next();
							}
							}else {
								System.out.println("게임 그만하고 싶나요??");
							}
							}
						} else if (choiceGenre == i && choiceLevel == 2) {
							for(int a = 0; a < 3; a++) {
								System.out.println("노래를 듣고 제목을 입력해주세요");
								System.out.println("재생은 1번 입니다.");
							int star = sc.nextInt();
							if(star == 1) {
							for(int j = 0; j < 3; j++) {
							mp3.play(dao.Hard_Ballad(ran[j]));
							System.out.println(dao.Hard_Ballad(ran[j]));
								
							System.out.print("정답을 입력해 주세요 : ");
							String userAnswer = sc.next();
							
							System.out.println("다시 들어보려면 R을 입력하세요");
							String replay = sc.next();
							}
							}else {
								System.out.println("게임 그만하고 싶나요??");
							}
						}

						}else if (choiceGenre == 2 && choiceLevel == 1) {
							for(int a = 0; a < 3; a++) {
								System.out.println("노래를 듣고 제목을 입력해주세요");
								System.out.println("재생은 1번 입니다.");
							int star = sc.nextInt();
							if(star == 1) {
							for(int j = 0; j < 3; j++) {
							mp3.play(dao.Easy_Dance(ran[j]));
							System.out.println(dao.Easy_Dance(ran[j]));
								
							System.out.print("정답을 입력해 주세요 : ");
							String userAnswer = sc.next();
							
							System.out.println("다시 들어보려면 R을 입력하세요");
							String replay = sc.next();
							}
							}else {
								System.out.println("게임 그만하고 싶나요??");
							}
						} 
						}else if (choiceGenre == 2 && choiceLevel == 2) {
							for(int a = 0; a < 3; a++) {
								System.out.println("노래를 듣고 제목을 입력해주세요");
								System.out.println("재생은 1번 입니다.");
							int star = sc.nextInt();
							if(star == 1) {
							for(int j = 0; j < 3; j++) {
							mp3.play(dao.Hard_Dance(ran[j]));
							System.out.println(dao.Hard_Dance(ran[j]));
								
							System.out.print("정답을 입력해 주세요 : ");
							String userAnswer = sc.next();
							
							System.out.println("다시 들어보려면 R을 입력하세요");
							String replay = sc.next();
							}
							}else {
								System.out.println("게임 그만하고 싶나요??");
							}
						} 
						}else if (choiceGenre == 3 && choiceLevel == 1) {

							for(int a = 0; a < 3; a++) {
								System.out.println("노래를 듣고 제목을 입력해주세요");
								System.out.println("재생은 1번 입니다.");
							int star = sc.nextInt();
							if(star == 1) {
							for(int j = 0; j < 3; j++) {
							mp3.play(dao.Easy_Hiphop(ran[j]));
							System.out.println(dao.Easy_Hiphop(ran[j]));
								
							System.out.print("정답을 입력해 주세요 : ");
							String userAnswer = sc.next();
							
							System.out.println("다시 들어보려면 R을 입력하세요");
							String replay = sc.next();
							}
							}else {
								System.out.println("게임 그만하고 싶나요??");
							}
						} 
						}else if (choiceGenre == 3 && choiceLevel == 2) {
							for(int a = 0; a < 3; a++) {
								System.out.println("노래를 듣고 제목을 입력해주세요");
								System.out.println("재생은 1번 입니다.");
							int star = sc.nextInt();
							if(star == 1) {
							for(int j = 0; j < 3; j++) {
							mp3.play(dao.Hard_Hiphop(ran[j]));
							System.out.println(dao.Hard_Hiphop(ran[j]));
								
							System.out.print("정답을 입력해 주세요 : ");
							String userAnswer = sc.next();
							
							System.out.println("다시 들어보려면 R을 입력하세요");
							String replay = sc.next();
							}
							}else {
								System.out.println("게임 그만하고 싶나요??");
							}
						}
					}
				} 
					}else {
					System.out.println("넌 누구길래 동료인 척 하는거지?");
				}
			} 
			
			}else if (input == 3) {

				System.out.println("==================== 전체 랭킹 ====================");
				ArrayList<PlayerDTO> List = dao.Ranking();
				for (int i = 0; i < List.size(); i++) {
					System.out.println(List.get(i).getID() + " / " + List.get(i).getPOINT());
				}

			} else if (input == 4) {

				System.out.println("======= 게임 설명 =======");
				System.out.println("짧게 나오는 노래를 듣고 제목을 맞추는 게임입니다. 아는 노래라면 정답을 입력해보세여!");
			}

		}
//		if (choiceGenre == 1 && choiceLevel == 1) {
//
//			System.out.println("발라드 easy모드");
//			String userAnswer = sc.next();
//			
//			
//		} else if (choiceGenre == 1 && choiceLevel == 2) {
//
//			System.out.println("발라드 hard모드");
//			String userAnswer = sc.next();
//
//		} else if (choiceGenre == 2 && choiceLevel == 1) {
//			System.out.println("댄스 easy모드");
//			String userAnswer = sc.next();
//
//		} else if (choiceGenre == 2 && choiceLevel == 2) {
//			System.out.println("댄스 hard모드");
//			String userAnswer = sc.next();
//
//		} else if (choiceGenre == 3 && choiceLevel == 1) {
//			System.out.println("힙합 easy모드");
//			String userAnswer = sc.next();
//		} else if (choiceGenre == 3 && choiceLevel == 2) {
//
//			System.out.println("힙합 hard모드");
//			String userAnswer = sc.next();
//		}
		}
	}

}