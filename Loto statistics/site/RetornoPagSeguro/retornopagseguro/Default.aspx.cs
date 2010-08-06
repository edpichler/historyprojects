using System;
using System.IO;
using System.Net;
using System.Text;
using System.Web;
using System.Web.UI;
using log4net;
using log4net.Config;
using MySql.Data.MySqlClient;

/// <summary>
/// Ao receber o post do pagseguro, deve confirmar a veracidade do post no site.
/// Após confirmada, deve guardar os dados de todos os parâmetros.
/// </summary>
public partial class _Default : Page
{
    private static readonly ILog log = LogManager.GetLogger(typeof (_Default));
   
    

    protected void Page_Load(object sender, EventArgs e)
    {
        if(Request.Form.Count < 1)
        {
            return;
        }
        string strFormValues = Request.Form.ToString();        

        XmlConfigurator.Configure();
        log.Info("Request form params: " + Request.Form);
        try
        {
            string strNewValue;
            string strResponse;
            string Token = "ED7CD567B87354B9AC807FFCFCE86CAC";


            // Cria o HttpWebRequest
            var req =
                (HttpWebRequest) WebRequest.Create("https://pagseguro.uol.com.br/Security/NPI/Default.aspx");

            // Prepara os valores para o envio à PagSeguro
            req.Method = "POST";
            req.ContentType = "application/x-www-form-urlencoded";
            strNewValue = strFormValues + "&Comando=validar&Token=" + Token;
            req.ContentLength = strNewValue.Length;

            // Envia para a PagSeguro a string para validação dos dados
            var stOut = new StreamWriter(req.GetRequestStream(), Encoding.Default);
            stOut.Write(strNewValue);
            stOut.Close();


            // Recupera os dados da PagSeguro com o resultado VERIFICADO ou FALSO
            var stIn = new StreamReader(req.GetResponse().GetResponseStream(), Encoding.UTF8);
            strResponse = stIn.ReadToEnd();
            stIn.Close();

            // Confirma quando o NPI está VERIFICADO ou FALSO. Se FALSO, então ignore o NPI
            // SOMENTE SALVE OS DADOS CASO O RESULTADO SEJA IGUAL À "VERIFICADO"
            if (strResponse.Equals("VERIFICADO"))
            {
                log.Info("Post verdadeiro. Verificado na UOL:" + strResponse);
                // Salva os dados no Banco de Dados

                /*
                 * Estava no exemplo em java:            
                 * Verifique se a TransacaoID não foi previamente processada
                 * Verifique se o email recebido (VendedorEmail) é o seu email
                 * Verifique se o valor do pagamento está correto
                 * Processe o pagamento salvando os dados em seu banco de dados
                 * */                
                new DataBaseManager().salvaRequestPagSeguro(Request);
                
                log.Debug
                if(!String.IsNullOrEmpty(Request["ProdID_1"]) && Request["ProdID_1"].Equals("1")){
                    informaTransactionIdOnView(Request["TransacaoID"]);
                }    
            else
            {
                log.Warn("O request não foi validado na UOL:" + strResponse);
            }
        }
        catch (Exception ex)
        {
            log.Error(ex.Message, ex);
        }
    }    

    /// <summary>
    /// Se o produto for o lotochance, mostra o transactionID.
    /// </summary>
    private void informaTransactionIdOnView(String transId)
    {
        this.Label1.Text = transId;
    }
}