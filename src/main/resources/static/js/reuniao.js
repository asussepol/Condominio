$('#confirmacaoExclusaoReuniao').on('show.bs.modal', function(event) {

	var button = $(event.relatedTarget);

	var codigoUnidade = button.data('codigo');
	//alert(codigoUnidade);
	// var modal = $(this).find('form');
	// form.attr('action','/unidades/' + codigoUnidade)
	var modal = $(this);
	var form = modal.find('form');
	var action = form.attr('action');

	if (!action.endsWith('/')) {

		action += '/';
	}
	 form.attr('action',action + codigoUnidade);

});