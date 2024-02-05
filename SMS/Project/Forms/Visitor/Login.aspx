<%@ Page Title="" Theme="Theme" Language="C#" MasterPageFile="~/Forms/Masters/Visitor.master" AutoEventWireup="true" CodeFile="Login.aspx.cs" Inherits="Forms_Visitor_Login" %>

<asp:Content ID="Content1" ContentPlaceHolderID="VisitorHead" runat="Server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="VisitorBody" runat="Server">
    <div class="col-md-3"></div>
    <div class="form-group col-md-6">
        <h3 class="lead"><span class="glyphicon glyphicon-log-in"></span>&nbsp;&nbsp; Login : 
        </h3>
        <hr style="border-color: black;" />
        <div class="form-group">
            <asp:Label ID="lblUserName" runat="server" Text="User Name" AssociatedControlID="txtUserName" SkinID="lbl"></asp:Label>
            <asp:TextBox ID="txtUserName" runat="server" Placeholder="User Name" SkinID="txt"></asp:TextBox>
            <asp:RequiredFieldValidator ID="RequiredtxtUserName" runat="server" ErrorMessage="Please enter user name" ControlToValidate="txtUserName" Display="Dynamic" ForeColor="Red" Font-Size="Large"></asp:RequiredFieldValidator>
        </div>
        <div class="form-group">
            <asp:Label ID="lblPassword" runat="server" Text="Password" AssociatedControlID="txtPassword" SkinID="lbl"></asp:Label>
            <asp:TextBox ID="txtPassword" runat="server" TextMode="Password" Placeholder="password" SkinID="txt"></asp:TextBox>
            <asp:RequiredFieldValidator ID="RequiredtxtPassword" runat="server" ErrorMessage="Please enter password" ControlToValidate="txtPassword" Display="Dynamic" ForeColor="Red" Font-Size="Large"></asp:RequiredFieldValidator>
        </div>

        <div class="form-group" style="text-align: center;">
            <asp:Button ID="btnLogin" runat="server" Text="Login" OnClick="btnLogin_Click" SkinID="btn" />
        </div>
    </div>
</asp:Content>

