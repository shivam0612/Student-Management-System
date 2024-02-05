<%@ Page Title="" Language="C#" MasterPageFile="~/Forms/Masters/Admin.master" AutoEventWireup="true" CodeFile="Default.aspx.cs" Inherits="Forms_Admin_Student_Default" %>

<asp:Content ID="Content1" ContentPlaceHolderID="AdminHead" runat="Server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="AdminBody" runat="Server">
    <div class="Form">
        <h1>Index</h1>
        <hr />
        <a href="Create.aspx">Create new
        </a>

        <!------------------------------------>
        <asp:GridView
            ID="GridIndex"
            runat="server"
            Class="table table-responsive table-hover"
            AutoGenerateColumns="False"
            CellPadding="4"
            DataKeyNames="Id"
            DataSourceID="IndexDataSource"
            ForeColor="Black"
            GridLines="Horizontal"
            ShowHeaderWhenEmpty="True"
            BackColor="White"
            BorderColor="#CCCCCC"
            BorderStyle="None"
            BorderWidth="1px"
            OnRowCommand="GridIndex_RowCommand"
            OnRowEditing="GridIndex_RowEditing"
            OnRowDeleting="GridIndex_RowDeleting" OnSelectedIndexChanged="GridIndex_SelectedIndexChanged">
            <Columns>
                <asp:BoundField DataField="Id" HeaderText="Id" ReadOnly="True" SortExpression="Id" InsertVisible="False" />

                <asp:BoundField DataField="name" HeaderText="name" SortExpression="name" />

                <asp:BoundField DataField="contact" HeaderText="contact" SortExpression="contact" />

                <asp:TemplateField>
                    <ItemTemplate>
                        <asp:LinkButton ID="btnEdit" runat="server" CommandName="Edit" Text="Edit" Font-Size="18px" />
                        |
                        <asp:LinkButton ID="btnDetails" runat="server" CommandName="Details" Text="Details" Font-Size="18px" />
                        |
                        <asp:LinkButton ID="btnDelete" runat="server" CommandName="Delete" Text="Delete" Font-Size="18px" />
                    </ItemTemplate>
                </asp:TemplateField>


            </Columns>
            <FooterStyle BackColor="#CCCC99" ForeColor="Black" />
            <HeaderStyle BackColor="#333333" Font-Bold="True" ForeColor="White" Font-Size="18px" />
            <RowStyle Font-Size="17px" />
            <PagerStyle BackColor="White" ForeColor="Black" HorizontalAlign="Right" />
            <SelectedRowStyle BackColor="#CC3333" Font-Bold="True" ForeColor="White" />
            <SortedAscendingCellStyle BackColor="#F7F7F7" />
            <SortedAscendingHeaderStyle BackColor="#4B4B4B" />
            <SortedDescendingCellStyle BackColor="#E5E5E5" />
            <SortedDescendingHeaderStyle BackColor="#242121" />

        </asp:GridView>
        <asp:SqlDataSource ID="IndexDataSource" runat="server" ConnectionString="<%$ ConnectionStrings:ConnectionString %>" SelectCommand="SELECT * FROM [Student]" ProviderName="System.Data.OleDb"></asp:SqlDataSource>
    </div>
</asp:Content>

