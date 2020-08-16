import React from "react";
import { Button, Form, Col } from 'react-bootstrap';
function LoginForm() {
    return (
        <div className="col-md-5 col-md-offset-2">
        <Form>
            <Form.Row>
                <Col>
                    <Form.Control placeholder="First name" />
                </Col>
                <Col>
                    <Form.Control placeholder="Last name" />
                </Col>
                <Button variant="primary" type="submit">
                        Submit
                </Button>
            </Form.Row>
        </Form>
        </div>
    );
}

export default LoginForm;