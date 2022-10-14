package kr.or.iei.vo;

public class LgTV implements TV {
	@Override
	public void powerOn() {
		System.out.println("LGTV -------- 전원을 켠다.");
	}
	@Override
	public void powerOff() {
		System.out.println("LGTV -------- 전원을 끈다.");
	}
	@Override
	public void volumeUp() {
		System.out.println("LGTV -------- 소리 올린다.");
	}
	@Override
	public void volumeDown() {
		System.out.println("LGTV -------- 소리 내린다.");
	}
}
