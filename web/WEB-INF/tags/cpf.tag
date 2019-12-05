<%@tag description="Campo CPF" pageEncoding="UTF-8"%>

<%@attribute name="id"%>
<%@attribute name="nome"%>
<%@attribute name="classe"%>
<%@attribute name="valor"%>

<input type="text" id="${id}" name="${nome}" 
       class="${classe}" value="${valor}"  />

<script src="resources/js/jquery.mask.min.js"></script>

<script>
    $(document).ready(
        function(){
            var campo = $("#${id}");
            campo.mask("000.000.000-00");
        }
    );
    
</script>

