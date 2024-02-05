<%@ Page Title="" Theme="theme" Language="C#" MasterPageFile="~/Forms/Masters/Faculty.master" AutoEventWireup="true" CodeFile="Attendance.aspx.cs" Inherits="Forms_Faculty_Attendance" %>

<asp:Content ID="Content1" ContentPlaceHolderID="FacultyHead" runat="Server">
    <style type="text/css">
        .mycheckBig input {
            width: 25px;
            height: 25px;
        }

        .mycheckSmall input {
            width: 10px;
            height: 10px;
        }

        .label {
            text-size-adjust: auto;
        }
    </style>
</asp:Content>

<asp:Content ID="Content2" ContentPlaceHolderID="FacultyBody" runat="Server">
    <div class="col-md-12 TitleCenter40" contenteditable="false">
        Enter Attendance : Class- 
        <asp:Label ID="lblclass" name="class_name" runat="server"></asp:Label>
        <br />
        <hr />
        

        <asp:GridView ID="GridView1" runat="server" CellPadding="5" ForeColor="#333333" GridLines="None" AutoGenerateColumns="False" DataKeyNames="Id" Width="100%" ViewStateMode="Enabled">
            <AlternatingRowStyle BackColor="White" ForeColor="#284775" />

            <Columns>
                <asp:BoundField DataField="Id" HeaderText="Id" InsertVisible="False" ReadOnly="True" SortExpression="Id" HeaderStyle-CssClass="gridheader" />
                <asp:BoundField DataField="name" HeaderText="Name" SortExpression="name" ApplyFormatInEditMode="True" HeaderStyle-CssClass="gridheader" />
                <asp:TemplateField HeaderText="Present / Absent" HeaderStyle-CssClass="gridheader">
                    <ItemTemplate>
                        <asp:CheckBox ID="chkbx" runat="server" CssClass="mycheckBig" />
                    </ItemTemplate>
                </asp:TemplateField>

            </Columns>

            <EditRowStyle BackColor="#999999" />
            <FooterStyle BackColor="#5D7B9D" Font-Bold="True" ForeColor="White" />
            <HeaderStyle BackColor="#5D7B9D" Font-Bold="True" ForeColor="White" />

        </asp:GridView>
        <asp:Button ID="btnSubmit" runat="server" Text="Submit" SkinID="btn" OnClick="btnSubmit_Click" />

    </div>



</asp:Content>

