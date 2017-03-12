/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handgeometryauth;

/**
 *
 * @author PubuduC
 */
public class UserProfile {
	private final String username;
	private final float[] fingerLength;
	private final float[] fingerWidth;
	private final float[] fingerTipToFirstDivisionLength;
	
	public UserProfile(String username,
	float[] fingerLength,
	float[] fingerWidth,
	float[] fingerTipToFirstDivisionLength){
            this.username=username;
            this.fingerLength=fingerLength;
            this.fingerWidth=fingerWidth;
            this.fingerTipToFirstDivisionLength=fingerTipToFirstDivisionLength;
	}
	public String getUsername(){
		return username;
	}
	public float[] getFingerLength(){
		return fingerLength;
	}
	public float[] getFingerWidth(){
		return fingerWidth;
	}
	public float[] getFingerTipToFirstDivisionLength(){
		return fingerTipToFirstDivisionLength;
	}
}
    


