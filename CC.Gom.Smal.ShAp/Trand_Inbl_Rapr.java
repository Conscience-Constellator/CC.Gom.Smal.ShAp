package CC.Encycloped.Abs.Scal.Gom;

import CC.COd.Finishd;
import CC.COd.Lin_DclAr;
import CC.COd.Neds_Ovrid;
import static CC.COd.Neds_Ovrid.*;

import CC.Encycloped.Abs.Scal.Gom.RL_LOc_Havr_Rapr;
import CC.Encycloped.Abs.Scal.Gom.ShAp.Inbl_Rapr;
import CC.Encycloped.Abs.Scal.Gom.SpAc;
import java.util.List;
import static CC.Math.Arithmetc.Sub;
import static CC.Encycloped.Abs.Org.Syc.TXt.Num.List$String;

public interface Trand_Inbl_Rapr<SpAc_Typ extends SpAc,Rapd_Inbl_Typ extends Trand_Inbl<SpAc_Typ,?>> extends
	Inbl_Rapr<Rapd_Inbl_Typ>,Trand_Inbl<SpAc_Typ,Rapd_Inbl_Typ>, RL_LOc_Havr_Rapr<SpAc_Typ>
{
	@Override @Neds_Ovrid(NEds=No) @Finishd(Is_Finishd=true)
	default SpAc_Typ Get_SpAc()
	{return Get_Rapd_Inbl().Get_SpAc();}

	@Override @Neds_Ovrid(NEds=No) @Finishd(Is_Finishd=true)
	default List<In_Acount> Get_In_Acountg()
	{return Get_Rapd_Inbl().Get_In_Acountg();}

	interface Setbl_Inbl_Rapr<SpAc_Typ extends SpAc,Rapd_Inbl_Typ extends Trand_Inbl<SpAc_Typ,?>>
	  extends Trand_Inbl_Rapr<SpAc_Typ,Rapd_Inbl_Typ>
	{
		@Lin_DclAr @Neds_Ovrid(NEds=Yes) @Finishd(Is_Finishd=true)
		void Set_Rapd_Inbl(Rapd_Inbl_Typ Rapd);
	}
	abstract class Trand_Inbl_Rapr_ConcrEt<SpAc_Typ extends SpAc,Rapd_Inbl_Typ extends Trand_Inbl<SpAc_Typ,?>>
		implements Setbl_Inbl_Rapr		  <SpAc_Typ,Rapd_Inbl_Typ>,RL_LOc_Havr_Rapr<SpAc_Typ>
	{
		@Finishd(Is_Finishd=true)
		private Rapd_Inbl_Typ Rapd_Inbl;
			@Override @Neds_Ovrid(NEds=No) @Finishd(Is_Finishd=true)
			public final Rapd_Inbl_Typ Get_Rapd_Inbl()
			{return Rapd_Inbl;}
			@Override @Neds_Ovrid(NEds=Ok) @Finishd(Is_Finishd=true)
			public void Set_Rapd_Inbl(Rapd_Inbl_Typ Rapd)
			{Rapd_Inbl=Rapd;}
			@Override @Neds_Ovrid(NEds=No) @Finishd(Is_Finishd=true)
			public final Rapd_Inbl_Typ Get_Rapd_LOc_Havr()
			{return Get_Rapd_Inbl();}

		@Finishd(Is_Finishd=true)
		public Trand_Inbl_Rapr_ConcrEt(Rapd_Inbl_Typ Rapd)
		{Set_Rapd_Inbl(Rapd);}
	}
}