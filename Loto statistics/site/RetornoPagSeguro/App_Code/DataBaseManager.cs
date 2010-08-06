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
using MySql.Data.MySqlClient;

/// <summary>
/// Summary description for Class1
/// </summary>
public class DataBaseManager
{
    private static readonly ILog log = LogManager.GetLogger(typeof (DataBaseManager));

    public DataBaseManager()
    {
    }

    public void salvaRequestPagSeguro(HttpRequest rquestpagSeguro)
    {
        MySqlConnection conn = null;
        MySqlTransaction trans = null;
        try
        {
            conn = getConnection();

            MySqlCommand cmd = conn.CreateCommand();

            conn.Open();
            cmd.Connection = conn;
            trans = conn.BeginTransaction();

            cmd.CommandText =
                @"INSERT INTO PagSeguroTransacoes 
                (TransacaoID, VendedorEmail, 
                Referencia,
                TipoFrete,
                ValorFrete,
                Extras,
                Anotacao,
                TipoPagamento,
                StatusTransacao,
                CliNome,
                CliEmail,
                CliEndereco,
                CliNumero,
                CliComplemento,
                CliBairro,
                CliCidade,
                CliEstado,
                CliCEP	,
                CliTelefone,
                NumItens) 

                VALUES(@TransacaoID,
                @VendedorEmail, 
                @Referencia,
                @TipoFrete,
                @ValorFrete,
                @Extras,
                @Anotacao,
                @TipoPagamento,
                @StatusTransacao,
                @CliNome,
                @CliEmail,
                @CliEndereco,
                @CliNumero,
                @CliComplemento,
                @CliBairro,
                @CliCidade,
                @CliEstado,
                @CliCEP	,
                @CliTelefone,
                @NumItens)";

            cmd.Prepare();

            cmd.Parameters.Add("@TransacaoID", MySqlDbType.String).Value = rquestpagSeguro.Form["TransacaoID"];
            cmd.Parameters.Add("@VendedorEmail", MySqlDbType.String).Value = rquestpagSeguro.Form["VendedorEmail"];
            cmd.Parameters.Add("@Referencia", MySqlDbType.String).Value = rquestpagSeguro.Form["Referencia"];
            cmd.Parameters.Add("@TipoFrete", MySqlDbType.String).Value = rquestpagSeguro.Form["TipoFrete"];
            cmd.Parameters.Add("@ValorFrete", MySqlDbType.Decimal).Value =
                Decimal.Parse(rquestpagSeguro.Form["ValorFrete"]);
            cmd.Parameters.Add("@Extras", MySqlDbType.Decimal).Value = Decimal.Parse(rquestpagSeguro.Form["Extras"]);
            cmd.Parameters.Add("@Anotacao", MySqlDbType.String).Value = rquestpagSeguro.Form["Anotacao"];
            cmd.Parameters.Add("@TipoPagamento", MySqlDbType.String).Value = rquestpagSeguro.Form["TipoPagamento"];
            cmd.Parameters.Add("@StatusTransacao", MySqlDbType.String).Value = rquestpagSeguro.Form["StatusTransacao"];
            cmd.Parameters.Add("@CliNome", MySqlDbType.String).Value = rquestpagSeguro.Form["CliNome"];
            cmd.Parameters.Add("@CliEmail", MySqlDbType.String).Value = rquestpagSeguro.Form["CliEmail"];
            ;
            cmd.Parameters.Add("@CliEndereco", MySqlDbType.String).Value = rquestpagSeguro.Form["CliEndereco"];
            ;
            cmd.Parameters.Add("@CliNumero", MySqlDbType.String).Value = rquestpagSeguro.Form["CliNumero"];
            ;
            cmd.Parameters.Add("@CliComplemento", MySqlDbType.String).Value = rquestpagSeguro.Form["CliComplemento"];
            ;
            cmd.Parameters.Add("@CliBairro", MySqlDbType.String).Value = rquestpagSeguro.Form["CliBairro"];
            ;
            cmd.Parameters.Add("@CliCidade", MySqlDbType.String).Value = rquestpagSeguro.Form["CliCidade"];
            ;
            cmd.Parameters.Add("@CliEstado", MySqlDbType.String).Value = rquestpagSeguro.Form["CliEstado"];
            ;
            cmd.Parameters.Add("@CliCEP", MySqlDbType.String).Value = rquestpagSeguro.Form["CliCEP"];
            ;
            cmd.Parameters.Add("@CliTelefone", MySqlDbType.String).Value = rquestpagSeguro.Form["CliTelefone"];
            ;
            int numerodeitens = Int32.Parse(rquestpagSeguro.Form["NumItens"]);
            cmd.Parameters.Add("@NumItens", MySqlDbType.String).Value = numerodeitens;


            cmd.ExecuteNonQuery();

            cmd = conn.CreateCommand();
            cmd.Parameters.Clear();
            cmd.CommandText =
                @"INSERT INTO PagSeguroTransacoesProdutos (TransacaoID, ProdID, ProdDescricao, 
                            ProdValor, ProdQuantidade, ProdFrete ,ProdExtras)
            VALUES(@TransacaoID, @ProdID, @ProdDescricao, 
                            @ProdValor, @ProdQuantidade, @ProdFrete ,@ProdExtras)";

            cmd.Parameters.Add("@TransacaoID", MySqlDbType.String).Value = rquestpagSeguro.Form["TransacaoID"];

            for (int i = 1; i <= numerodeitens; i++)
            {
                cmd.Parameters.Add("@ProdID", MySqlDbType.Int32).Value = Int32.Parse(rquestpagSeguro.Form["ProdID_" + i]);
                cmd.Parameters.Add("@ProdDescricao", MySqlDbType.String).Value =
                    rquestpagSeguro.Form["ProdDescricao_" + i];
                cmd.Parameters.Add("@ProdValor", MySqlDbType.Decimal).Value =
                    Decimal.Parse(rquestpagSeguro.Form["ProdValor_" + i]);
                cmd.Parameters.Add("@ProdQuantidade", MySqlDbType.String).Value =
                    rquestpagSeguro.Form["ProdQuantidade_" + i];
                cmd.Parameters.Add("@ProdFrete", MySqlDbType.String).Value =
                    Decimal.Parse(rquestpagSeguro.Form["ProdFrete_" + i]);
                cmd.Parameters.Add("@ProdExtras", MySqlDbType.String).Value =
                    Decimal.Parse(rquestpagSeguro.Form["ProdExtras_" + i]);
                cmd.ExecuteNonQuery();
            }

            trans.Commit();
            log.Info("Commitado! Post do pagseguro foi Salvo no BD com sucesso!");
        }
        catch (Exception exc)
        {
            log.Error("Erro ao salvar no BD.", exc);
            if (trans != null)
            {
                trans.Rollback();
                log.Info("Feito o rollback.");
            }
        }
        finally
        {
            if (conn != null)
            {
                conn.Close();
                log.Debug("Fechou conexão com BD.");
            }
        }
    }

    private MySqlConnection getConnection()
    {
        MySqlConnection conn;
        conn = new MySqlConnection("server=dbmy0004.whservidor.com;uid=megaloteria;" +
                                   "pwd=sgdb2008;database=megaloteria;");
        return conn;
    }

    public ResultadoValidacaoChave verificaChave(string chave, String mac)
    {
        DataSet dataset = doSqlQuery(@"select * FROM 
        PagSeguroTransacoes P  
            where transacaoId = @transid
        order by timestamp desc", new[]{new MySqlParameter("@transid", chave)} );


        DataRowCollection rows = dataset.Tables[0].Rows;
        if(rows.Count > 0)
        {

            String ostatus = (rows[0]["StatusTransacao"] != DBNull.Value ? rows[0]["StatusTransacao"].ToString().ToUpper() : "");
            if(ostatus != null)
            {
                if (ostatus.Equals("Aprovado".ToUpper()) || ostatus.Equals("Completo".ToUpper()))
                {
                    //verifica se já foi ativado 
                    bool jaAtivado = verificaSeJaFoiAtivadoEmOutroMac(chave, mac);
                    if(jaAtivado)
                    {
                        log.Debug("Chave já ativada! " + chave + " para o mac " + mac);
                        return new ResultadoValidacaoChave(false, ResultadoValidacaoChave.JA_ATIVADA_OUTRO_MAC);
                        
                    }
                    log.Debug("Chave válida! " + chave + " para o mac=" + mac);
                    this.associaChaveAoMac(chave, mac);
                    return new ResultadoValidacaoChave(true, null);
                }

            }else
            {
                log.Debug("Ainda não foi confirmado o pagamento. Chave " + chave + " para o mac " + mac);
                return new ResultadoValidacaoChave(false, ResultadoValidacaoChave.EM_APROVACAO + " Situação do pagamento: " + ostatus.ToUpper());
            }
        }
        log.Debug("Nenhuma transação encontrada:" + chave);
        return new ResultadoValidacaoChave(false, ResultadoValidacaoChave.NAO_ENCONTRADO_TRANSACTION_ID);
    }

    /// <summary>
    /// Verifica se a chave já foi usada para ativar um outro mac.
    /// </summary>
    /// <param name="chave"></param>
    /// <param name="mac"></param>
    /// <returns></returns>
    private bool verificaSeJaFoiAtivadoEmOutroMac(string chave, string mac)
    {
        log.Debug("Verificando se chave " + chave + " já foi ativado em algum macaddress");
        DataSet dataset = doSqlQuery(@"select * FROM 
        AtivacoesOnlineMacAddress
            where transacaoId = @transid            
        order by timestamp desc", new[]{new MySqlParameter("@transid", chave)} );

        DataRowCollection rows = dataset.Tables[0].Rows;
        foreach (DataRow row in rows)
        {
            object obj = row["macaddress"];
            if (obj != null && obj != DBNull.Value)
            {
                if(!obj.ToString().Equals(mac))
                {
                    log.Debug("A chave " + chave + " já foi ativado com o macaddress" + obj);
                    return true;
                }
            }
        }
        log.Debug("A chave " + chave + " ainda não foi ativada");
        return false;
    }

    public DataSet doSqlQuery(String sql, MySqlParameter[] parametros)
    {
        MySqlConnection conn = getConnection();

        MySqlTransaction trans = null;
        try
        {
            log.Debug("Executando sql...");
            conn = getConnection();

            MySqlCommand cmd = conn.CreateCommand();

            conn.Open();
            cmd.Connection = conn;
            trans = conn.BeginTransaction();

            cmd.CommandText = sql;
           
            cmd.Prepare();
            if (parametros != null)
            {
                foreach (MySqlParameter param in parametros)
                {
                    cmd.Parameters.Add(param);
                }
            }

            MySqlDataAdapter myDA = new MySqlDataAdapter(cmd);
            DataSet myDS = new DataSet();
            myDA.Fill(myDS);

            trans.Commit();
            log.Debug("Commitado! ");
            return myDS;
        }
        catch (Exception exc)
        {
            log.Error("Erro ao executar sql no BD.", exc);
            if (trans != null)
            {
                trans.Rollback();
                log.Info("Feito o rollback.");
            }
        }
        finally
        {
            if (conn != null)
            {
                conn.Close();
                log.Debug("Fechou conexão com BD.");
            }
        }
        return null;
    }
    
    /// <summary>
    /// 
    /// </summary>
    /// <param name="sql"></param>
    /// <param name="parametros"></param>
    /// <returns></returns>
    public int executeNonQuery(String sql, MySqlParameter[] parametros)
    {
        log.Debug("Executando non query... ");
        MySqlConnection conn = getConnection();
        try
        {
            conn = getConnection();

            MySqlCommand cmd = conn.CreateCommand();

            conn.Open();
            cmd.Connection = conn;
           

            cmd.CommandText = sql;

            cmd.Prepare();
            if (parametros != null)
            {
                foreach (MySqlParameter param in parametros)
                {
                    cmd.Parameters.Add(param);
                }
            }

            int res = cmd.ExecuteNonQuery();
            log.Info("Executado query: " + res + " linhas afetadas");
            return res;
        }
        catch (Exception exc)
        {
            log.Error("Erro ao executar sql no BD.", exc);
        }
        finally
        {
            if (conn != null)
            {
                conn.Close();
                log.Debug("Fechou conexão com BD.");
            }
        }
        return -1;
    }

    internal void associaChaveAoMac(string chave, string macAddress)
    {
        log.Debug("Associando chave " + chave + " para o mac=" + macAddress);

        //associar somente se não tenha já sido associado
        DataSet dataset=  this.doSqlQuery("select count(*) from AtivacoesOnlineMacAddress where transacaoid = @transid",
                        new[] {new MySqlParameter("@transid", chave)});
        if (Int32.Parse(dataset.Tables[0].Rows[0][0].ToString()) < 1)
        {
            executeNonQuery(
                @"insert into AtivacoesOnlineMacAddress(macaddress, transacaoId)
            values(@mac, @transId) ",
                new[] {new MySqlParameter("@transid", chave), new MySqlParameter("@mac", macAddress)});
            log.Debug("Chave associada.");
        }else
        {
            log.Debug("Chave já foi associada anteriormente.");
        }
        

    }
}