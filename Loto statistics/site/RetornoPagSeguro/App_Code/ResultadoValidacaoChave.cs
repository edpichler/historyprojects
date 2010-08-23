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

/// <summary>
/// Summary description for ResultadoValidacaoChave
/// </summary>
public class ResultadoValidacaoChave
{
    private bool _valido;
    private string _mensagem;
    public static string EM_APROVACAO = "A instituição financeira ainda não confirmou o pagamento.";
    public const string NAO_ENCONTRADO_TRANSACTION_ID = "Não foi encontrado nenhum pagamento relacionado a chave informada";
    public const string JA_ATIVADA_OUTRO_MAC = "Esta chave já foi ativada em outro computador.";
    

    public ResultadoValidacaoChave()
	{
		
	}

    public ResultadoValidacaoChave(bool valido, String mensagem)
    {
        this.Valido = valido;
        this.Mensagem = mensagem;
    }

    public string Mensagem
    {
        get { return _mensagem; }
        set { _mensagem = value; }
    }

    public bool Valido
    {
        get { return _valido; }
        set { _valido = value; }
    }

    public override string ToString()
    {
        if(this.Valido)
        {
            return this.Valido.ToString();
        }else
        {
            return this.Mensagem;
        }
    }
}
