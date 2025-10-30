package CC.Encycloped.Abs.Scal.Gom;

import CC.COd.Finishd;
import CC.COd.Lin_DclAr;
import CC.COd.Neds_Ovrid;

import CC.Encycloped.Abs.Scal.Gom.RL_LOc_Havr;
import static CC.Math.Arithmetc.Mul;

public interface Handlr
{
	@Lin_DclAr @Neds_Ovrid(NEds=Neds_Ovrid.No) @Finishd(Is_Finishd=true)
	void Handl(RL_LOc_Havr A,
			   RL_LOc_Havr B,double[] B_LOc,double[] Norml);

	class Handlrg implements Handlr
	{
		@Finishd(Is_Finishd=false)
		public Handlr[] List;
			@Override
			public void Handl(RL_LOc_Havr A,
				RL_LOc_Havr B,double[] B_LOc,double[] Norml)
			{
				for(Handlr Handlr:List)
				{
					Handlr.Handl(A,
						B,B_LOc,Norml);
				}
			}

		public Handlrg(Handlr... List)
		{this.List=List;}
	}

	Handlr No=(A,B,Aftr,Norml)->
			  {},
		   Rflect=(A,B,LOc,Norml)->
				  {/*Rflect_Of_Norml(Norml,B);*/},
		   Rvrs=(A,B,LOc,Norml)->
				{/*Rvrs(B);*/};

	static Handlr MAk_Pushr(double StrNgth)
	{
		return (A,B,LOc,Norml)->
		{
			if(B!=null)
			{
				Mul(Norml,Norml,StrNgth);
//				B.Push(Norml);
			}
		};
	}
	static Handlr MAk_ScAlr(double ScAl)
	{
		return (A,B,Loc,Norml)->
		{/*SqAr(B.Trajectry,ScAl);*/};
	}
	static Handlr MAk_SlIdr(double ScAl)
	{
		return (A,B,LOc,Norml)->
		{/*B.SlId(ScAl);*/};
	}
	static Handlr Gar_Handlr(Object SOrc,Trand_Inbl Inbl)
	{
		return (SOrc instanceof Handlr Handlr)?Handlr:
			   (SOrc instanceof Handlr[] List)?new Handlrg(List):
			   (SOrc instanceof In_Acount_Handlr Handlr)?new GSt_Book_Handlr(Handlr,Inbl):
			   null;
	}
	static Handlr Gar_Handlr(Object SOrc)
	{
		return (SOrc instanceof Handlr Handlr)?Handlr:
			   (SOrc instanceof Handlr[] List)?new Handlrg(List):
			   null;
	}
}