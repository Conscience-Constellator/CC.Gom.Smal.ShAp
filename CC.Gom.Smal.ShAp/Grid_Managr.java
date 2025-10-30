package CC.Encycloped.Abs.Scal.Gom;

import CC.COd.Finishd;

import java.util.List;
import CC.List.List_Managr;

import static CC.List.BAs_ArA.AB;
import static CC.Encycloped.Abs.Scal.Gom.Gom.Grid$SpAc;
import static CC.Encycloped.Abs.Scal.Gom.Grid_Managr_.Min_Rectangl;
import static java.lang.Math.*;

public class Grid_Managr implements List_Managr<RL_LOc_Havr>
{
	@Finishd(Is_Finishd=false)
	public static void D2_Digit(int[] ArA,int Num,int X_LNg)
	{AB(ArA,Num%X_LNg,Num/X_LNg);}

	public static void N(List<RL_LOc_Havr> List,int Loc_Num,double BtwEn)
	{
		int[] Grid_LNgg=Min_Rectangl(Loc_Num);
		int
			X_LNg_Grid=Grid_LNgg[0],
			Y_LNg_Grid=Grid_LNgg[1];
		double
			X_Rad_SpAc=((X_LNg_Grid-1)*BtwEn)/2,
			Y_Rad_SpAc=((Y_LNg_Grid-1)*BtwEn)/2,
			Z=max(Y_Rad_SpAc,BtwEn);

		int[] Grid_Loc=new int[2];
		double[] SpAc_Loc=new double[2];
		for(int IndX=0;IndX<Loc_Num;IndX+=1)
		{
			D2_Digit(Grid_Loc,IndX,X_LNg_Grid);
			Gom.Grid$SpAc(
				SpAc_Loc,
				Grid_Loc[0],
				Grid_Loc[1],
				BtwEn);
			RL_LOc_Havr Object=List.get(IndX);
			Object.UpdAt_RL_LOc(
				SpAc_Loc[0]-X_Rad_SpAc,
				SpAc_Loc[1]-Y_Rad_SpAc,
				Z);
			Object.UpdAt();
		}
	}

	public double BtwEn;
		@Override
		public void Manag(List<RL_LOc_Havr> List,int Num)
		{N(List,Num,BtwEn);}

	public Grid_Managr(double BtwEn)
	{this.BtwEn=BtwEn;}
}