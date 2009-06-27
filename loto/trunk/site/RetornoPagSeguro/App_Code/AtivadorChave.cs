using System;
using System.Data;
using System.Configuration;
using System.Linq;
using System.Web;
using System.Web.Security;
using System.Web.UI;
using System.Web.UI.HtmlControls;
using System.Web.UI.WebControls;
using System.Web.UI.WebControls.WebParts;
using System.Xml.Linq;
using log4net;

/// <summary>
/// Summary description for Class1
/// </summary>
public class AtivadorChave
{
    private static readonly ILog log = LogManager.GetLogger(typeof(AtivadorChave));
	public AtivadorChave()
	{
        
	}

    public ResultadoValidacaoChave validaChave(string chave, string macAddress)
    {  //se puder ativar retorna true e salva no bd a nova chave mac
        //se não puder ativar, retorna falso e o motivo. Caso nao foi pago ou já está em outro mac, ou simplesmente não existe a chave informada.
        DataBaseManager dbman = new DataBaseManager();
        log.Debug("Verificando chave chave=" + chave + " para o mac=" + macAddress);
        ResultadoValidacaoChave res = dbman.verificaChave(chave, macAddress);
        
        return res;
    }
}
