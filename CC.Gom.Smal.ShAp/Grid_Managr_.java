package CC.Encycloped.Abs.Scal.Gom;

import CC.Encycloped.Abs.Org.Comput.Bi.Bit;
import java.util.Arrays;
import java.util.List;
import CC.List.List_Managr;
import static CC.List.BAs_ArA.AB;
import static CC.Math.CoP.SqAr;

import		  CC.Encycloped.Abs.Scal.Gom.ShAp.Out_Box_Getbl;
import static CC.Encycloped.Abs.Scal.Gom.ShAp.Out_Box_Getbl.*;
import static CC.Encycloped.Abs.Scal.Gom.Grid_Managr.D2_Digit;
import static java.lang.Math.max;
import static java.lang.Math.sqrt;

import static java.lang.System.out;

public class Grid_Managr_ implements List_Managr<RL_LOc_Havr>
{
	public static boolean In_Ny(double[] Object,double[][] Boxg,
								int IndX,int Nd)
	{
		for(;IndX<Nd
			;IndX+=1)
		{
			if(Is_Box_Som_In_Box(Object,Boxg[IndX]))
			{return true;}
		}
		return false;
	}
		public static boolean In_Ny(double[] Object_Box,double[][] Boxg,int X)
		{
			return In_Ny(Object_Box,Boxg,0,X)||
				   In_Ny(Object_Box,Boxg,X+1,Boxg.length);
		}
			public static boolean In_Ny(double[][] Boxg,int X)
			{
				double[] Object_Box=Boxg[X];

				return In_Ny(Object_Box,Boxg,X);
			}
	public static void Itr_PlAc(Out_Box_Getbl Object,List<? extends Out_Box_Getbl> Objectg,int IndX,RL_LOc_Havr StRt,
								double BtwEn,double MRgin,int Try_Limit)
	{
		RL_LOc_Havr Object_=(RL_LOc_Havr)Object;
		double Z=Object_.Get_LOc_CoP_As_ArA()[2];
		double[][] Boxg=Get_Out_Boxg(Objectg);
		for(int Try_Num=0;Try_Num<Try_Limit;Try_Num+=1)
		{
			double[] Box=Object.Get_Bordr_Out_Box_StRt();
			if(Box!=null)
			{DialAt(Box,MRgin);}
			out.println("Itr:"+Arrays.toString(Box));
			if(In_Ny(Box,Boxg,IndX))
			{
				int[] Spirl_Loc=SqAr_Spirl_Rad(Try_Num);
				out.println(Arrays.toString(Spirl_Loc));
				Object_.UpdAt_RL_LOc(
					Spirl_Loc[0]*BtwEn,
					Spirl_Loc[1]*BtwEn,
					0);
				Object_.UpdAt();
			}
			else
			{
				out.println("Placed after "+Try_Num+" adjustments");
				return;
			}
		}
		throw new RuntimeException("Couldn't place object in "+Try_Limit+" tries");
	}
		public static void Itr_PlAc(
			List<? extends Out_Box_Getbl> Objectg,int IndX,RL_LOc_Havr StRt,
			double BtwEn,double MRgin,int Try_Limit)
		{Itr_PlAc(Objectg.get(IndX),Objectg,IndX,StRt,BtwEn,MRgin,Try_Limit);}
	public static int[] Min_Rectangl(int Num)
	{
		int Y=(int)sqrt(Num);

		return new int[]{Num/Y,Y};
	}
	public static int Min_SqAr(int Num)
	{
		int Y=(int)sqrt(Num);

		return max(
			Num/Y,
			Y);
	}
	public static int[] SqAr_Ring(int Num,int LNg)
	{
		Num-=SqAr(LNg-2);

		switch(Num/(LNg*4))
		{
			case 0->{return new int[]{0,Num};}
			case 1->{return new int[]{Num-LNg,LNg};}
			case 2->{return new int[]{LNg,Num%LNg};}
			case 3->{return new int[]{Num%LNg,0};}
			default->{throw new RuntimeException();}
		}
	}
	public static int[] SqAr_Ring_Rad(int Num,int LNg)
	{
		Num-=SqAr(LNg-2);
		int Rad=LNg/2;

		switch(Num/(LNg*4))
		{
			case 0->{return new int[]{-Rad,Num-Rad};}
			case 1->{return new int[]{Num-Rad,Rad};}
			case 2->{return new int[]{Rad,(Num%LNg)-Rad};}
			case 3->{return new int[]{(Num%LNg)-Rad,-Rad};}
			default->{throw new RuntimeException();}
		}
	}
	public static int[] SqAr_Ring_(int Num,int LNg)
	{return SqAr_Ring(Num,LNg);}
	public static int[] SqAr_Spirl(int Num)
	{return SqAr_Ring(Num,Min_SqAr(Num+1));}
	public static int[] SqAr_Spirl_Rad(int Num)
	{return SqAr_Ring_Rad(Num,Min_SqAr(Num+1));}
	public static void Evn_Grid(
		List<RL_LOc_Havr> List,RL_LOc_Havr[][] Grid,
		int X_LNg_Grid,int Y_LNg_Grid,
		double[] X_LNgg,double[] Y_LNgg)
	{
		int[] Grid_Loc=new int[2];
		RL_LOc_Havr Object;
		double[] Box=new double[6];
		for(int IndX=0,X,Y;IndX<List.size();IndX+=1)
		{
			D2_Digit(Grid_Loc,IndX,X_LNg_Grid);
			X=Grid_Loc[0];
			Y=Grid_Loc[1];
			Object=List.get(IndX);
			Grid[Y][X]=Object;
			Out_Box_Getbl.Get_Bordr_Out_Box_StRt(Object,Box);
			X_LNgg[X]=Box[0];
			Y_LNgg[Y]=Box[1];
		}
	}
	public static void Grid_To_SpAc(double[] Loc,
		int X,double[] X_Totl,
		int Y,double[] Y_Totl,
		double BtwEn)
	{
		AB(Loc,
			X_Totl[X]+(X*BtwEn),
			Y_Totl[Y]+(Y*BtwEn));
	}
	public static void N(List<RL_LOc_Havr> List,int Num,double BtwEn)
	{
		int[] Grid_LNgg=Min_Rectangl(Num);
		int
			X_LNg_Grid=Grid_LNgg[0],
			Y_LNg_Grid=Grid_LNgg[1];
		double[]
			X_LNgg=new double[X_LNg_Grid],
			Y_LNgg=new double[Y_LNg_Grid];
		RL_LOc_Havr[][] Grid=new RL_LOc_Havr[Y_LNg_Grid][X_LNg_Grid];
		Evn_Grid(List,Grid,X_LNg_Grid,Y_LNg_Grid,X_LNgg,Y_LNgg);

		double
			X_Rad_SpAc=((X_LNg_Grid-1)*BtwEn)/2,
			Y_Rad_SpAc=((Y_LNg_Grid-1)*BtwEn)/2,
			Z=max(Y_Rad_SpAc,BtwEn);

		double[] SpAc_Loc=new double[2],
			X_Totlg=Bit.Totlg(X_LNgg),
			Y_Totlg=Bit.Totlg(Y_LNgg);
		for(int Y=0;Y<Y_LNg_Grid;Y+=1)
		{
			for(int X=0;X<X_LNg_Grid;X+=1)
			{
				Grid_To_SpAc(
					SpAc_Loc,
					X,X_LNgg,
					Y,Y_LNgg,
					BtwEn);
				RL_LOc_Havr Object=Grid[Y][X];
				Object.UpdAt_RL_LOc(
					SpAc_Loc[0]-X_Rad_SpAc,
					SpAc_Loc[1]-Y_Rad_SpAc,
					Z);
				Object.UpdAt();
			}
		}
	}

	public double BtwEn;
		@Override
		public void Manag(List<RL_LOc_Havr> List,int Num)
		{N(List,Num,BtwEn);}

	public Grid_Managr_(double BtwEn)
	{this.BtwEn=BtwEn;}
}