        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!-- Breadcrumb Start -->
        <div class="breadcrumb-wrap mt-3">
            <div class="container-fluid">
                <ul class="breadcrumb">
                    <li class="breadcrumb-item"><a href="#">Home</a></li>
                    <li class="breadcrumb-item"><a href="#">heo</a></li>
                    <li class="breadcrumb-item active">Cart</li>
                </ul>
            </div>
        </div>
        <!-- Breadcrumb End -->
        
        <!-- Cart Start -->
        <div class="cart-page" ng-controller="myController">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-8">
                        <div class="cart-page-inner">
                            <div class="table-responsive">
                                <table class="table table-bordered">
                                    <thead class="thead-dark">
                                        <tr>
                                            <th>Heo</th>
                                            <th>Price</th>
                                            <th>Quantity</th>
                                            <th>Total</th>
                                            <th>Remove</th>
                                        </tr>
                                    </thead>
                                    <tbody class="align-middle">
                                   <c:forEach var="heo" items="${heos }">
                                        <tr>
                                            <td>
                                                <div class="img">
                                                    <a href="#"><img src="/storage/${heo.value.heo.image }" alt="Image"></a>
                                                    <p>${heo.value.heo.name }</p>
                                                </div>
                                            </td>
                                            <td>$${heo.value.price }</td>
                                            <td>
                                                <div class="qty">
                                                    <form action="/changeQuantity/${heo.key }">
                                                    <c:if test="${heo.value.quantity > 1}">
                                                    <button class="btn-minus"><i class="fa fa-minus"></i></button>
                                                    </c:if>
                                                    <input type="text" onchange="quantity()" class="text-center" id="changeQuantity" name="quantity" value="${heo.value.quantity }">
                                                   <c:if test="${heo.value.quantity < heo.value.heo.quantity}">
                                                    <button class="btn-plus"><i class="fa fa-plus"></i></button>
                                                    </c:if>
                                                    </form>
                                                </div>
                                            </td>
                                            <td>$${heo.value.price * heo.value.quantity }</td>
                                            <td><a href="/deleteCart/${heo.key }" type="button" ><i class="fa fa-trash"></i></a></td>
                                        </tr>
                                       </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <div class="cart-page-inner">
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="coupon">
                                        <input type="text" placeholder="Coupon Code">
                                        <button>Apply Code</button>
                                    </div>
                                </div>
                                <div class="col-md-12">
                                <form action="/thanh-toan">
                                    <div class="cart-summary">
                                        <div class="cart-content">
                                            <h1>Cart Summary</h1>
                                            <p>Sub Total<span>$${total }</span></p>
                                            <p>Shipping Cost<span>$0</span></p>
                                            <h2>Grand Total<span>$${total }</span></h2>
                                        </div>
                                        <div class="cart-btn">
                                            <a type="button" href="/deletesCart" class="btn mx-4">Delete Cart</a>                                       
                                          <button>Checkout</button>
                                        </div>
                                    </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Cart End -->
        
     
