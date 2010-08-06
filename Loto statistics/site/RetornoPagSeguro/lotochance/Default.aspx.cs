using System;
using System.Collections;
using System.Configuration;
using System.Data;
using System.Linq;
using System.Web;
using System.Web.Security;
using System.Web.UI;
using System.Web.UI.HtmlControls;
using System.Web.UI.WebControls;
using System.Web.UI.WebControls.WebParts;
using System.Xml.Linq;
using log4net;
using log4net.Config;
using log4net.Repository.Hierarchy;

/// <summary>
/// Por esta classe que o software irá ativar online.
/// </summary>
public partial class lotochance_Default : System.Web.UI.Page
{

    private static readonly ILog log = LogManager.GetLogger(typeof(lotochance_Default));
    protected void Page_Load(object sender, EventArgs e)
    {
        Response.Charset = "UTF-8";
        XmlConfigurator.Configure();

        String chave = Request.Params["chave"]; 
        String mac = Request.Params["mac"];
        if(!String.IsNullOrEmpty(chave) && !String.IsNullOrEmpty(mac))
        {
            log.Debug("Recebido request: chave=" + chave + ", mac=" + mac);
            verificarChave(chave,mac);
        }
       
       
    }

    /**
     * Verifica se a chave é real. Retorna true se já foi pago.
     */
    private void verificarChave(string chave, string macAddress)
    {
        log.Debug("Verificando chave chave=" + chave + " para o mac=" + macAddress);
        ResultadoValidacaoChave resultado = new AtivadorChave().validaChave(chave, macAddress);
        Response.Write(resultado);
        //se puder ativar retorna true e salva no bd a nova chave mac
        //se não puder ativar, retorna falso e o motivo. Caso nao foi pago ou já está em outro mac, ou simplesmente não existe a chave informada.
    }
}
