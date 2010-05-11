zenexity.capdemat.tools.namespace("zenexity.capdemat.fong");

(function() {

  var zcf = zenexity.capdemat.fong;
  var zcc = zenexity.capdemat.common;
  var zct = zenexity.capdemat.tools;
  var yue = YAHOO.util.Event;
  var yus = YAHOO.util.Selector;

  zcf.AddressAutocomplete = function() {

    return {
      init: function() {
        zct.each(yus.query(".address-fieldset"), function() {
          var fieldsetId = this.id;
          var streetNameAutocomplete = new zcc.AutoComplete({
            inputId: fieldsetId + ".streetName",
            modalId: fieldsetId + "_streetName_autocomplete",
            url: "/CapDemat/autocomplete/ways",
            idField: "matriculation",
            minimumChars: 2,
            resultText: function(result) {
              return result.name;
            },
            inputValue: function(result) {
              return result.name;
            },
            onSelectedResult: function(result) {
              document.getElementById(fieldsetId + ".streetMatriculation").value = result.matriculation;
            }
          });
          new zcc.AutoComplete({
            inputId: fieldsetId + ".city",
            modalId: fieldsetId + "_city_autocomplete",
            url: "/CapDemat/autocomplete/cities",
            idField: "inseeCode",
            resultText: function(result) {
              return result.postalCode + " " + result.name;
            },
            inputValue: function(result) {
              return result.name;
            },
            onSelectedResult: function(result) {
              document.getElementById(fieldsetId + ".postalCode").value = result.postalCode;
              streetNameAutocomplete.urlParams.city = result.inseeCode;
              document.getElementById(fieldsetId + ".cityInseeCode").value = result.inseeCode;
              document.getElementById(fieldsetId + ".streetName").value = "";
              document.getElementById(fieldsetId + ".streetMatriculation").value = "";
            }
          });
          new zcc.AutoComplete({
            inputId: fieldsetId + ".postalCode",
            modalId: fieldsetId + "_postalCode_autocomplete",
            url: "/CapDemat/autocomplete/cities",
            urlParams: { postalCode: true },
            idField: "inseeCode",
            minimumChars: 2,
            resultText: function(result) {
              return result.postalCode + " " + result.name;
            },
            inputValue: function(result) {
              return result.postalCode;
            },
            onSelectedResult: function(result) {
              document.getElementById(fieldsetId + ".city").value = result.name;
              streetNameAutocomplete.urlParams.city = result.inseeCode;
              document.getElementById(fieldsetId + ".cityInseeCode").value = result.inseeCode;
              document.getElementById(fieldsetId + ".streetName").value = "";
              document.getElementById(fieldsetId + ".streetMatriculation").value = "";
            }
          });
        });
      }
    };
  }();

  yue.onDOMReady(zcf.AddressAutocomplete.init);

}());

