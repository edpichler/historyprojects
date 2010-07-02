<%@ Page Language="C#" AutoEventWireup="true"  CodeFile="Default.aspx.cs" Inherits="_Default" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Untitled Page</title>
</head>
<body>
    <form id="form1" runat="server">
    Obrigado por comprar!
    <br />
    A sua chave de ativação é
    <asp:Label ID="Label1" runat="server" Text="..." Font-Bold="True" 
        Font-Size="XX-Large"></asp:Label>
    .
    <br />
    Após a confirmação do pagamento pela instituição financeira, você deve usá-la 
    para ativar seu produto. Será enviado um email quando assim que o pagamento for 
    confirmado. O tempo máximo de confirmação é de dois dias úteis.</form>
    </body>
</html>
