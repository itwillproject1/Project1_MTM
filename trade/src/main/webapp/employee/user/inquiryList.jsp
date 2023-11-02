<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../inn/head/databaseList.jsp"/>
<head><title>문의 목록</title></head>
<jsp:include page="../inn/navbar.jsp"/>
      <main role="main" class="main-content">
        <div class="container-fluid">
          <div class="row justify-content-center">
            <div class="col-12">
              <div class="row">
                <!-- Small table -->
                <div class="col-md-12 my-4">
                  <h2 class="h4 mb-1">문의 목록</h2>
                  <div class="card shadow">
                    <div class="card-body">
                      <div class="toolbar">
                        <form class="form">
                          <div class="form-row">
                            <div class="form-group col-auto mr-auto">
                              <label class="my-1 mr-2 sr-only" for="inlineFormCustomSelectPref1">Show</label>
                              <select class="custom-select mr-sm-2" id="inlineFormCustomSelectPref1">
                                <option value="">...</option>
                                <option value="1">12</option>
                                <option value="2" selected>32</option>
                                <option value="3">64</option>
                                <option value="3">128</option>
                              </select>
                            </div>
                            <div class="form-group col-auto">
                              <label for="search" class="sr-only">Search</label>
                              <input type="text" class="form-control" id="search1" value="" placeholder="Search">
                            </div>
                          </div>
                        </form>
                      </div>
                      <!-- table -->
                      <table class="table table-borderless table-hover">
                        <thead>
                          <tr>
                            <td>
                              <div class="custom-control custom-checkbox">
                                <input type="checkbox" class="custom-control-input" id="all2">
                                <label class="custom-control-label" for="all2"></label>
                              </div>
                            </td>
                            <th>ID</th>
                            <th>User</th>
                            <th>Company</th>
                            <th>Contact</th>
                            <th class="w-25">Bio</th>
                            <th>Date</th>
                            <th>Action</th>
                          </tr>
                        </thead>
                        <tbody>
                          <tr>
                            <td>
                              <div class="custom-control custom-checkbox">
                                <input type="checkbox" class="custom-control-input" id="2474">
                                <label class="custom-control-label" for="2474"></label>
                              </div>
                            </td>
                            <td>
                              <div class="avatar avatar-md">
                                <img src="./assets/avatars/face-3.jpg" alt="..." class="avatar-img rounded-circle">
                              </div>
                            </td>
                            <td>
                              <p class="mb-0 text-muted"><strong>Brown, Asher D.</strong></p>
                              <small class="mb-0 text-muted">2474</small>
                            </td>
                            <td>
                              <p class="mb-0 text-muted">Accumsan Consulting</p>
                              <small class="mb-0 text-muted">Ap #331-7123 Lobortis Avenue</small>
                            </td>
                            <td>
                              <p class="mb-0 text-muted"><a href="#" class="text-muted">(958) 421-0798</a></p>
                              <small class="mb-0 text-muted">Nigeria</small>
                            </td>
                            <td class="w-25"><small class="text-muted"> Egestas integer eget aliquet nibh praesent. In hac habitasse platea dictumst quisque sagittis purus.</small></td>
                            <td class="text-muted">13/09/2020</td>
                            <td><button class="btn btn-sm dropdown-toggle more-horizontal" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="text-muted sr-only">Action</span>
                              </button>
                              <div class="dropdown-menu dropdown-menu-right">
                                <a class="dropdown-item" href="#">Edit</a>
                                <a class="dropdown-item" href="#">Remove</a>
                                <a class="dropdown-item" href="#">Assign</a>
                              </div>
                            </td>
                          </tr>
                          <tr>
                            <td>
                              <div class="custom-control custom-checkbox">
                                <input type="checkbox" class="custom-control-input" id="2786">
                                <label class="custom-control-label" for="2786"></label>
                              </div>
                            </td>
                            <td>
                              <div class="avatar avatar-md">
                                <img src="./assets/avatars/face-1.jpg" alt="..." class="avatar-img rounded-circle">
                              </div>
                            </td>
                            <td>
                              <p class="mb-0 text-muted"><strong>Leblanc, Yoshio V.</strong></p>
                              <small class="mb-0 text-muted">2786</small>
                            </td>
                            <td>
                              <p class="mb-0 text-muted">Fringilla Ornare Placerat Consulting</p>
                              <small class="mb-0 text-muted">287-8300 Nisl. St</small>
                            </td>
                            <td>
                              <p class="mb-0 text-muted"><a href="#" class="text-muted">(899) 881-3833</a></p>
                              <small class="mb-0 text-muted">Papua New Guinea</small>
                            </td>
                            <td class="w-25"><small class="text-muted"> Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</small></td>
                            <td class="text-muted">04/05/2019</td>
                            <td><button class="btn btn-sm dropdown-toggle more-horizontal" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="text-muted sr-only">Action</span>
                              </button>
                              <div class="dropdown-menu dropdown-menu-right">
                                <a class="dropdown-item" href="#">Edit</a>
                                <a class="dropdown-item" href="#">Remove</a>
                                <a class="dropdown-item" href="#">Assign</a>
                              </div>
                            </td>
                          </tr>
                          <tr>
                            <td>
                              <div class="custom-control custom-checkbox">
                                <input type="checkbox" class="custom-control-input" id="2747">
                                <label class="custom-control-label" for="2747"></label>
                              </div>
                            </td>
                            <td>
                              <div class="avatar avatar-md">
                                <img src="./assets/avatars/face-2.jpg" alt="..." class="avatar-img rounded-circle">
                              </div>
                            </td>
                            <td>
                              <p class="mb-0 text-muted"><strong>Hester, Nissim L.</strong></p>
                              <small class="mb-0 text-muted">2747</small>
                            </td>
                            <td>
                              <p class="mb-0 text-muted">Tristique Ltd</p>
                              <small class="mb-0 text-muted">4577 Cras St.</small>
                            </td>
                            <td>
                              <p class="mb-0 text-muted"><a href="#" class="text-muted">(977) 220-6518</a></p>
                              <small class="mb-0 text-muted">Central African Republic</small>
                            </td>
                            <td class="w-25"><small class="text-muted"> Non tellus orci ac auctor augue. Elit at imperdiet dui accumsan sit.</small></td>
                            <td class="text-muted">21/08/2019</td>
                            <td><button class="btn btn-sm dropdown-toggle more-horizontal" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="text-muted sr-only">Action</span>
                              </button>
                              <div class="dropdown-menu dropdown-menu-right">
                                <a class="dropdown-item" href="#">Edit</a>
                                <a class="dropdown-item" href="#">Remove</a>
                                <a class="dropdown-item" href="#">Assign</a>
                              </div>
                            </td>
                          </tr>
                          <tr>
                            <td>
                              <div class="custom-control custom-checkbox">
                                <input type="checkbox" class="custom-control-input" id="2639">
                                <label class="custom-control-label" for="2639"></label>
                              </div>
                            </td>
                            <td>
                              <div class="avatar avatar-md">
                                <img src="./assets/avatars/face-4.jpg" alt="..." class="avatar-img rounded-circle">
                              </div>
                            </td>
                            <td>
                              <p class="mb-0 text-muted"><strong>Gardner, Leigh S.</strong></p>
                              <small class="mb-0 text-muted">2639</small>
                            </td>
                            <td>
                              <p class="mb-0 text-muted">Orci Luctus Et Inc.</p>
                              <small class="mb-0 text-muted">P.O. Box 228, 7512 Lectus Ave</small>
                            </td>
                            <td>
                              <p class="mb-0 text-muted"><a href="#" class="text-muted">(537) 315-1481</a></p>
                              <small class="mb-0 text-muted">United Kingdom</small>
                            </td>
                            <td class="w-25"><small class="text-muted"> Nunc pulvinar sapien et ligula ullamcorper malesuada proin. Neque convallis a cras semper auctor</small></td>
                            <td class="text-muted">04/08/2019</td>
                            <td><button class="btn btn-sm dropdown-toggle more-horizontal" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="text-muted sr-only">Action</span>
                              </button>
                              <div class="dropdown-menu dropdown-menu-right">
                                <a class="dropdown-item" href="#">Edit</a>
                                <a class="dropdown-item" href="#">Remove</a>
                                <a class="dropdown-item" href="#">Assign</a>
                              </div>
                            </td>
                          </tr>
                          <tr>
                            <td>
                              <div class="custom-control custom-checkbox">
                                <input type="checkbox" class="custom-control-input" id="2238">
                                <label class="custom-control-label" for="2238"></label>
                              </div>
                            </td>
                            <td>
                              <div class="avatar avatar-md">
                                <img src="./assets/avatars/face-5.jpg" alt="..." class="avatar-img rounded-circle">
                              </div>
                            </td>
                            <td>
                              <p class="mb-0 text-muted"><strong>Higgins, Uriah L.</strong></p>
                              <small class="mb-0 text-muted">2238</small>
                            </td>
                            <td>
                              <p class="mb-0 text-muted">Sit Amet Lorem Industries</p>
                              <small class="mb-0 text-muted">Ap #377-5357 Sed Road</small>
                            </td>
                            <td>
                              <p class="mb-0 text-muted"><a href="#" class="text-muted">(238) 386-0247</a></p>
                              <small class="mb-0 text-muted">Canada</small>
                            </td>
                            <td class="w-25"><small class="text-muted"> Libero id faucibus nisl tincidunt eget. Leo a diam sollicitudin tempor id. </small></td>
                            <td class="text-muted">26/07/2020</td>
                            <td><button class="btn btn-sm dropdown-toggle more-horizontal" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="text-muted sr-only">Action</span>
                              </button>
                              <div class="dropdown-menu dropdown-menu-right">
                                <a class="dropdown-item" href="#">Edit</a>
                                <a class="dropdown-item" href="#">Remove</a>
                                <a class="dropdown-item" href="#">Assign</a>
                              </div>
                            </td>
                          </tr>
                          <tr>
                            <td>
                              <div class="custom-control custom-checkbox">
                                <input type="checkbox" class="custom-control-input" id="2152">
                                <label class="custom-control-label" for="2152"></label>
                              </div>
                            </td>
                            <td>
                              <div class="avatar avatar-md">
                                <img src="./assets/avatars/face-6.jpg" alt="..." class="avatar-img rounded-circle">
                              </div>
                            </td>
                            <td>
                              <p class="mb-0 text-muted"><strong>Wheeler, Ralph F.</strong></p>
                              <small class="mb-0 text-muted">2152</small>
                            </td>
                            <td>
                              <p class="mb-0 text-muted">Suspendisse LLC</p>
                              <small class="mb-0 text-muted">Ap #410-5363 Non, Avenue</small>
                            </td>
                            <td>
                              <p class="mb-0 text-muted"><a href="#" class="text-muted">(587) 675-3258</a></p>
                              <small class="mb-0 text-muted">Chad</small>
                            </td>
                            <td class="w-25"><small class="text-muted"> Libero id faucibus nisl tincidunt eget. Leo a diam sollicitudin tempor id. </small></td>
                            <td class="text-muted">11/09/2019</td>
                            <td><button class="btn btn-sm dropdown-toggle more-horizontal" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="text-muted sr-only">Action</span>
                              </button>
                              <div class="dropdown-menu dropdown-menu-right">
                                <a class="dropdown-item" href="#">Edit</a>
                                <a class="dropdown-item" href="#">Remove</a>
                                <a class="dropdown-item" href="#">Assign</a>
                              </div>
                            </td>
                          </tr>
                          <tr>
                            <td>
                              <div class="custom-control custom-checkbox">
                                <input type="checkbox" class="custom-control-input" id="2488">
                                <label class="custom-control-label" for="2488"></label>
                              </div>
                            </td>
                            <td>
                              <div class="avatar avatar-md">
                                <img src="./assets/avatars/face-7.jpg" alt="..." class="avatar-img rounded-circle">
                              </div>
                            </td>
                            <td>
                              <p class="mb-0 text-muted"><strong>Kelley, Sonya Y.</strong></p>
                              <small class="mb-0 text-muted">2488</small>
                            </td>
                            <td>
                              <p class="mb-0 text-muted">Dolor Incorporated</p>
                              <small class="mb-0 text-muted">8250 Molestie St.</small>
                            </td>
                            <td>
                              <p class="mb-0 text-muted"><a href="#" class="text-muted">(934) 582-9495</a></p>
                              <small class="mb-0 text-muted">British Indian Ocean Territory</small>
                            </td>
                            <td class="w-25"><small class="text-muted"> A lacus vestibulum sed arcu non odio euismod lacinia. In tellus integer feugiat scelerisque.</small></td>
                            <td class="text-muted">30/03/2021</td>
                            <td><button class="btn btn-sm dropdown-toggle more-horizontal" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="text-muted sr-only">Action</span>
                              </button>
                              <div class="dropdown-menu dropdown-menu-right">
                                <a class="dropdown-item" href="#">Edit</a>
                                <a class="dropdown-item" href="#">Remove</a>
                                <a class="dropdown-item" href="#">Assign</a>
                              </div>
                            </td>
                          </tr>
                        </tbody>
                      </table>
                      <nav aria-label="Table Paging" class="mb-0 text-muted">
                        <ul class="pagination justify-content-center mb-0">
                          <li class="page-item"><a class="page-link" href="#">Previous</a></li>
                          <li class="page-item"><a class="page-link" href="#">1</a></li>
                          <li class="page-item active"><a class="page-link" href="#">2</a></li>
                          <li class="page-item"><a class="page-link" href="#">3</a></li>
                          <li class="page-item"><a class="page-link" href="#">Next</a></li>
                        </ul>
                      </nav>
                    </div>
                  </div>
                </div> <!-- customized table -->
              </div> <!-- end section -->
            </div>
          </div>
        </div>
      </main>
    </div>
<jsp:include page="../inn/footer.jsp"/>