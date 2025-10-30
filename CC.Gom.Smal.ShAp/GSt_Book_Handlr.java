package CC.Encycloped.Abs.Scal.Gom;

import CC.Encycloped.Abs.Scal.Gom.RL_LOc_Havr;
import java.util.List;

public class GSt_Book_Handlr implements Handlr
{
	public In_Acount_Handlr Rapd_Handlr;
		@Override
		public void Handl(RL_LOc_Havr A,
			RL_LOc_Havr B,double[] B_LOc,double[] Norml)
		{
			List<In_Acount> Acountg=Inbl.Get_In_Acountg();
			In_Acount Acount;
			for(int IndX=0;;
				IndX+=1)
			{
				if(IndX>=Acountg.size())
				{
					Acount=new In_Acount(B);
					Acountg.add(Acount);

					break;
				}
				else
				{
					Acount=Acountg.get(IndX);
					if(Acount.Object==B)
					{
						Acount.FrAm_Num+=1;

						break;
					}
				}
			}
			Rapd_Handlr.Handl(A,B,B_LOc,Norml,Acount);
		}

	public Trand_Inbl Inbl;

	public GSt_Book_Handlr(In_Acount_Handlr Rapd,Trand_Inbl Inbl)
	{
		Rapd_Handlr=Rapd;
		this.Inbl=Inbl;
	}
}