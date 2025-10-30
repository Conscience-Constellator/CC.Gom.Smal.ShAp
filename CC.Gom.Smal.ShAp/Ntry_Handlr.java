package CC.Encycloped.Abs.Scal.Gom;

import CC.COd.Lin_DclAr;

import CC.Encycloped.Abs.Scal.Gom.RL_LOc_Havr;

import static CC.UI.ConsOl.Print;

public class Ntry_Handlr implements In_Acount_Handlr
{
	public Handlr Ntr,In;
		@Lin_DclAr
		public void Set_Rapd_Handlrg(
			Handlr Ntr,
			Handlr In)
		{
			this.Ntr=Ntr;
			this.In=In;
		}
			@Override
			public void Handl(RL_LOc_Havr A,
				RL_LOc_Havr B,double[] LOc,double[] Norml,In_Acount Acount)
			{
//				out.println(Acount.FrAm_Num);
				((Acount.FrAm_Num>1)?
					In:
//					Print(
						Ntr
//					)
				).Handl(A,B,LOc,Norml);
			}

	public Ntry_Handlr(
		Handlr Ntr,
		Handlr In)
	{Set_Rapd_Handlrg(Ntr,In);}
}