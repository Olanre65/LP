import React, { useState } from "react";
import ProductService from "../services/ProductService";

const AddTutorial = () => {
  const initialTutorialState = {
    id: null,
    name: "",
    description: "",
    Category_Id: null,
    creation_date:"",
    update_date:"",
    Last_Purchased:""
  };
  const [tutorial, setProduct] = useState(initialProductState);
  const [submitted, setSubmitted] = useState(false);

  const handleInputChange = event => {
    const { name, value } = event.target;
    setProduct({ ...Product, [name]: value });
  };

  const saveProduct = () => {
    var data = {
      name: Product.name,
      description: Product.description,
      category_Id: Product.category_Id,
      creation_date: Product.creation_date,
      update_date: Product.update_date,
      Last_Purchased: Product.Last_Purchased
    };

    ProductDataService.create(data)
      .then(response => {
        setProduct({
          id: response.data.id,
          title: response.data.name,
          description: response.data.description,
          category_Id: response.data.descriptionl,
          creation_date:response.data.description,
          update_date:response.data.description,
          Last_Purchased:response.data.description
        });
        setSubmitted(true);
        console.log(response.data);
      })
      .catch(e => {
        console.log(e);
      });
  };

  const newProduct = () => {
    setTutorial(initialProductState);
    setSubmitted(false);
  };

  return (
    <div className="submit-form">
      {submitted ? (
        <div>
          <h4>You submitted successfully!</h4>
          <button className="btn btn-success" onClick={newProduct}>
            Add
          </button>
        </div>
      ) : (
        <div>
          <div className="form-group">
            <label htmlFor="name">Name</label>
            <input
              type="text"
              className="form-control"
              id="name"
              required
              value={Product.name}
              onChange={handleInputChange}
              name="name"
            />
          </div>

          <div className="form-group">
            <label htmlFor="description">Description</label>
            <input
              type="text"
              className="form-control"
              id="description"
              required
              value={Product.description}
              onChange={handleInputChange}
              name="description"
            />
          </div>

          <div className="form-group">
            <label htmlFor="category_Id">Category Id</label>
            <input
              type="text"
              className="form-control"
              id="description"
              required
              value={Product.category_Id}
              onChange={handleInputChange}
              name="category_id"
            />
          </div>

          <div className="form-group">
            <label htmlFor="description">Creation_Date</label>
            <input
              placeholder="Type Date"
              type="text"
              className="form-control"
              id="creation_date"
              required
              value={Product.creation_date}
              onChange={handleInputChange}
              name="creation_date"
            />
          </div>
          <div className="form-group">
            <label htmlFor="description">Updated_Date</label>
            <input
              placeholder="Type Date"
              type="text"
              className="form-control"
              id="Updated_date"
              required
              value={Product.update_date}
              onChange={handleInputChange}
              name="updated_date"
            />
          </div>

          <button onClick={saveProduct} className="btn btn-success">
            Submit
          </button>
        </div>
      )}
    </div>
  );
};

export default AddProduct;
