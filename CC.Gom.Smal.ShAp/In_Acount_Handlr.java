package CC.Encycloped.Abs.Scal.Gom;

import CC.COd.Finishd;
import CC.COd.Lin_DclAr;
import CC.COd.Neds_Ovrid;
import static CC.COd.Neds_Ovrid.*;

import CC.Encycloped.Abs.Scal.Gom.RL_LOc_Havr;

public interface In_Acount_Handlr
{
	@Lin_DclAr @Neds_Ovrid(NEds=Yes) @Finishd(Is_Finishd=true)
	void Handl(RL_LOc_Havr A,
		RL_LOc_Havr B,double[] LOc,double[] Norml,In_Acount Acount);
}