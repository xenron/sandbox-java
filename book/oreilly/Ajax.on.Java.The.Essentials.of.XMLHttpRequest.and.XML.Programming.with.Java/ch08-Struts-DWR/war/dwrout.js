function ProductManager() { } ProductManager.getProduct = function(p0, callback) { DWREngine._execute('/ajax-customer-lab7-Struts-DWR/dwr', 'ProductManager', 'getProduct', p0, callback); } ProductManager.getJSONProducts = function(callback) { DWREngine._execute('/ajax-customer-lab7-Struts-DWR/dwr', 'ProductManager', 'getJSONProducts', callback); } ProductManager.updateProductById = function(p0, p1, p2, callback) { DWREngine._execute('/ajax-customer-lab7-Struts-DWR/dwr', 'ProductManager', 'updateProductById', p0, p1, p2, callback); } ProductManager.deleteRow = function(p0, callback) { DWREngine._execute('/ajax-customer-lab7-Struts-DWR/dwr', 'ProductManager', 'deleteRow', p0, callback); } ProductManager.addProduct = function(callback) { DWREngine._execute('/ajax-customer-lab7-Struts-DWR/dwr', 'ProductManager', 'addProduct', callback); } 