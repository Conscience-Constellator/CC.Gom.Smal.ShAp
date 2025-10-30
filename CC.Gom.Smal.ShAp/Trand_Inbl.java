package CC.Encycloped.Abs.Scal.Gom;

/*Ubiq*/
import		  CC.COd.Finishd;
import		  CC.COd.Lin_DclAr;
import		  CC.COd.Neds_Ovrid;
import static CC.COd.Neds_Ovrid.*;

import CC.Encycloped.TIm.Tikbl;
import CC.Encycloped.Abs.Scal.Gom.RL_LOc_Havr;
import CC.Encycloped.Abs.Scal.Gom.SpAc;
import CC.Encycloped.Abs.Scal.Gom.ShAp.Inbl;
import CC.Encycloped.Abs.Scal.Gom.ShAp.Inbl_Rapr;
import CC.Encycloped.Abs.Scal.Gom.ShAp.Out_Box_Getbl;
import java.util.List;
import java.util.ArrayList;
import static CC.Math.Arithmetc.Sub;
import static CC.Encycloped.Abs.Org.Syc.TXt.Num.List$String;
import static CC.Encycloped.Abs.Org.Syc.TXt.Num.Dfalt_Mantisa_Lim;

public interface Trand_Inbl<SpAc_Typ extends SpAc,Rapd_Inbl_Typ extends Inbl>
	extends RL_LOc_Havr<SpAc_Typ>,
					   Inbl_Rapr<Rapd_Inbl_Typ>,Out_Box_Getbl,Tikbl
{
	@Override
	default int Get_Dim_Num()
	{return 3;}

	@Lin_DclAr
	void Set_Rapd_Inbl(Rapd_Inbl_Typ Rapd);
		@Override
		default boolean Is_In(double[] LOc)
		{return Inbl_Rapr.super.Is_In(Sub(LOc,Get_LOc_CoP_As_ArA()));}

	@Override
	default void Get_Trand_Bordr_Box_StRt(double[] Box,double[] Tran)
	{Get_Rapd_Inbl().Get_Trand_Bordr_Box_StRt(Box,Tran);}
		@Override
		default void Get_Bordr_Out_Box_StRt(double[] Box)
		{Get_Trand_Bordr_Box_StRt(Box,Get_LOc_CoP_As_ArA());}
	@Override
	default void Get_Trand_Bordr_Box(double[] Box,double[] Tran)
	{Get_Rapd_Inbl().Get_Trand_Bordr_Box(Box,Tran);}
		@Override
		default void Get_Bordr_Out_Box(double[] Box)
		{Get_Trand_Bordr_Box(Box,Get_LOc_CoP_As_ArA());}

	@Lin_DclAr
	List<In_Acount> Get_In_Acountg();
		@Lin_DclAr
		default In_Acount Get_Acount(RL_LOc_Havr Object)
		{
			for(int IndX=0;
				IndX<Get_In_Acountg().size();
				IndX+=1)
			{
				In_Acount Acount=Get_In_Acountg().get(IndX);
				if(Acount.Object==Object)
				{return Acount;}
			}
			return null;
		}
		@Lin_DclAr
		default void UnmRk_In_List()
		{
			for(int IndX=Get_In_Acountg().size()-1;
				IndX>=0;
				IndX-=1)
			{
				In_Acount Acount=Get_In_Acountg().get(IndX);
				if(!Acount.Is_In)
				{
					Get_In_Acountg().remove(IndX);

					break;
				}
				Acount.FrAm_Num+=1;
				Acount.Is_In=false;
			}
		}

	@Override
	default void Tik()
	{UnmRk_In_List();}

	@Lin_DclAr @Neds_Ovrid(NEds=Ok) @Finishd(Is_Finishd=true)
	default String To_String()
	{return Get_Rapd_Inbl()+"@"+List$String(Dfalt_Mantisa_Lim,Get_LOc_CoP_As_ArA());}

	class	   Trand_Inbl_ConcrEt<SpAc_Typ extends SpAc,Rapd_Inbl_Typ extends Inbl>
	extends RL_LOc_Havr_ConcrEt<SpAc_Typ>
	implements Trand_Inbl<SpAc_Typ,Rapd_Inbl_Typ>
	{
		@Finishd(Is_Finishd=true)
		private Rapd_Inbl_Typ Rapd_Inbl;
			@Override
			public Rapd_Inbl_Typ Get_Rapd_Inbl()
			{return Rapd_Inbl;}
			@Override
			public void Set_Rapd_Inbl(Rapd_Inbl_Typ Rapd)
			{Rapd_Inbl=Rapd;}

		@Finishd(Is_Finishd=true)
		public List<In_Acount> In_Acountg=new ArrayList<>();
			@Override @Neds_Ovrid(NEds=No) @Finishd(Is_Finishd=true)
			public final List<In_Acount> Get_In_Acountg()
			{return In_Acountg;}

		@Override @Neds_Ovrid(NEds=Ok) @Finishd(Is_Finishd=true)
		public String toString()
		{return To_String();}

		public Trand_Inbl_ConcrEt(RL_LOc_Havr<SpAc_Typ> Parnt,Object Loc_Sorc,
			Rapd_Inbl_Typ Rapd)
		{
			super(Parnt,Loc_Sorc);
			Set_Rapd_Inbl(Rapd);
		}
	}
}