<%@ Page Title="" Theme="Theme" Language="C#" MasterPageFile="~/Forms/Masters/Faculty.master" AutoEventWireup="true" CodeFile="CheckMarks.aspx.cs" Inherits="Forms_Faculty_CheckMarks" %>

<asp:Content ID="Content1" ContentPlaceHolderID="FacultyHead" runat="Server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="FacultyBody" runat="Server">
    <div class="col-md-12 TitleCenter40" contenteditable="false">
        Check Your Marks 

         <br />
        <hr />
    </div>

    <div class="col-md-3"></div>
    <div class="form-group col-md-6">


        <div class="form-group">
            <asp:Label ID="lblid" runat="server" Text="Enter id" AssociatedControlID="txtid" SkinID="lbl"></asp:Label>
            <asp:TextBox ID="txtid" runat="server" Placeholder="Enter student id" SkinID="txt"></asp:TextBox>
            <asp:RequiredFieldValidator ID="RequiredtxtUserName" runat="server" ErrorMessage="Please enter Id" ControlToValidate="txtid" Display="Dynamic" ForeColor="Red" Font-Size="Large"></asp:RequiredFieldValidator>
        </div>
        <div class="form-group">
            <asp:Label ID="lblsubject" runat="server" Text="Subject" AssociatedControlID="txtsubject" SkinID="lbl"></asp:Label>
            <asp:TextBox ID="txtsubject" runat="server" Placeholder="Enter Subject" SkinID="txt"></asp:TextBox>
            <asp:RequiredFieldValidator ID="RequiredtxtPassword" runat="server" ErrorMessage="Please enter Subject" ControlToValidate="txtsubject" Display="Dynamic" ForeColor="Red" Font-Size="Large"></asp:RequiredFieldValidator>
        </div>

        <div class="form-group" style="text-align: center; margin-bottom: 20px">
            <asp:Button ID="btncheck" runat="server" Text="check" SkinID="btn" OnClick="btncheck_Click" />





            <br />
        </div>
    </div>
               <div class="TitleCenter30 col-md-12" " contenteditable="false">

    <br />
    
    <asp:GridView ID="GridView1" runat="server" CellPadding="5" ForeColor="#333333" GridLines="None" AutoGenerateColumns="False" Width="100%" ViewStateMode="Enabled">
        <AlternatingRowStyle BackColor="White" ForeColor="#284775" />

        <Columns>
            <asp:BoundField DataField="testdate" HeaderText="Date" InsertVisible="False" ReadOnly="True" SortExpression="testdate" HeaderStyle-CssClass="gridheader">
                <HeaderStyle CssClass="gridheader"></HeaderStyle>
            </asp:BoundField>
            <asp:BoundField DataField="marks" HeaderText="Marks" SortExpression="marks" ApplyFormatInEditMode="True" HeaderStyle-CssClass="gridheader">
                <HeaderStyle CssClass="gridheader"></HeaderStyle>
            </asp:BoundField>
        </Columns>

        <EditRowStyle BackColor="#999999" />
        <FooterStyle BackColor="#5D7B9D" Font-Bold="True" ForeColor="White" />
        <HeaderStyle BackColor="#5D7B9D" Font-Bold="True" ForeColor="White" />

    </asp:GridView>
    </div>
















</asp:Content>

